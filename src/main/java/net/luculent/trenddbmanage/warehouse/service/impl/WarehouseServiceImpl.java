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

/**
 * 仓库服务实现类
 *
 * 实现了 {@link WarehouseService} 接口，包含对仓库的新增、修改、删除、分页查询等操作。
 * 使用 Hutool 的 BeanUtil 实现 DTO 与实体类之间的快速转换。
 */
@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseMapper warehouseMapper;

    /**
     * 创建仓库，设置默认状态为启用（1）
     *
     * @param request 仓库创建请求对象
     */
    @Override
    public void createWarehouse(WarehouseCreateRequest request) {
        Warehouse warehouse = BeanUtil.copyProperties(request, Warehouse.class);
        warehouse.setStatus(1); // 默认启用状态
        warehouseMapper.insertWarehouse(warehouse);
    }

    /**
     * 更新仓库信息
     *
     * @param request 仓库更新请求对象
     */
    @Override
    public void updateWarehouse(WarehouseUpdateRequest request) {
        Warehouse warehouse = BeanUtil.copyProperties(request, Warehouse.class);
        warehouseMapper.updateWarehouse(warehouse);
    }

    /**
     * 根据 ID 删除仓库
     *
     * @param request 仓库删除请求，包含 ID
     */
    @Override
    public void deleteWarehouse(WarehouseDeleteRequest request) {
        warehouseMapper.deleteWarehouseById(request.getId());
    }

    /**
     * 多条件分页查询仓库信息
     *
     * @param request 查询请求，包含条件和分页参数
     * @return 分页结果（总数 + 当前页记录）
     */
    @Override
    public PageResult<WarehouseResponse> queryWarehouses(WarehouseQueryRequest request) {
        int offset = (request.getPage() - 1) * request.getSize();

        // 查询符合条件的数据
        List<Warehouse> warehouses = warehouseMapper.selectListByConditions(
                request.getCode(),
                request.getName(),
                request.getManager(),
                offset,
                request.getSize()
        );

        // 查询总数
        int total = warehouseMapper.countByConditions(
                request.getCode(),
                request.getName(),
                request.getManager()
        );

        // 转换为响应对象列表
        List<WarehouseResponse> records = warehouses.stream()
                .map(w -> BeanUtil.copyProperties(w, WarehouseResponse.class))
                .collect(Collectors.toList());

        return new PageResult<>(total, records);
    }
}
