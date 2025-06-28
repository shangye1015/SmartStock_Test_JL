package net.luculent.trenddbmanage.warehouse.service.impl;


import lombok.RequiredArgsConstructor;
import net.luculent.trenddbmanage.common.model.PageResult;
import net.luculent.trenddbmanage.warehouse.dao.WarehouseMapper;
import net.luculent.trenddbmanage.warehouse.dto.*;
import net.luculent.trenddbmanage.warehouse.entity.Warehouse;
import net.luculent.trenddbmanage.warehouse.service.WarehouseService;
import org.springframework.stereotype.Service;
import cn.hutool.core.bean.BeanUtil;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseMapper warehouseMapper;

    @Override
    public void createWarehouse(WarehouseCreateRequest request) {
        Warehouse warehouse = BeanUtil.copyProperties(request, Warehouse.class);
        warehouse.setStatus(1);
        warehouseMapper.insertWarehouse(warehouse);
    }

    @Override
    public void updateWarehouse(WarehouseUpdateRequest request) {
        Warehouse warehouse = BeanUtil.copyProperties(request, Warehouse.class);
        warehouseMapper.updateWarehouse(warehouse);
    }

    @Override
    public void deleteWarehouse(WarehouseDeleteRequest request) {
        warehouseMapper.deleteWarehouseById(request.getId());
    }

    @Override
    public PageResult<WarehouseResponse> queryWarehouses(WarehouseQueryRequest request) {
        int offset = (request.getPage() - 1) * request.getSize();
        List<Warehouse> warehouses = warehouseMapper.selectListByConditions(
                request.getCode(),
                request.getName(),
                request.getManager(),
                offset,
                request.getSize()
        );

        int total = warehouseMapper.countByConditions(
                request.getCode(),
                request.getName(),
                request.getManager()
        );

        List<WarehouseResponse> records = warehouses.stream()
                .map(w -> BeanUtil.copyProperties(w, WarehouseResponse.class))
                .collect(Collectors.toList());

        return new PageResult<>(total, records);
    }
}

