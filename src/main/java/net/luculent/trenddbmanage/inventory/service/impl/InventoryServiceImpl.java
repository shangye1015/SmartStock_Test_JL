package net.luculent.trenddbmanage.inventory.service.impl;

import lombok.RequiredArgsConstructor;
import net.luculent.trenddbmanage.common.model.PageResult;
import net.luculent.trenddbmanage.inventory.dao.InventoryMapper;
import net.luculent.trenddbmanage.inventory.dto.InventoryQueryRequest;
import net.luculent.trenddbmanage.inventory.dto.InventoryResponse;
import net.luculent.trenddbmanage.inventory.service.InventoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 库存统计 Service 实现类
 * 实现库存分页查询逻辑
 *
 * @author shangye
 * @date 2025-06-28
 */
@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryMapper inventoryMapper;

    @Override
    public PageResult<InventoryResponse> queryInventory(InventoryQueryRequest request) {
        int offset = (request.getPage() - 1) * request.getSize();
        List<InventoryResponse> list = inventoryMapper.selectInventory(
                request.getWarehouseName(),
                request.getItemName(),
                offset,
                request.getSize()
        );
        int total = inventoryMapper.countInventory(
                request.getWarehouseName(),
                request.getItemName()
        );
        return new PageResult<>(total, list);
    }
}
