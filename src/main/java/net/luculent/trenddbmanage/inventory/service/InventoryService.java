package net.luculent.trenddbmanage.inventory.service;

import net.luculent.trenddbmanage.inventory.dto.InventoryQueryRequest;
import net.luculent.trenddbmanage.inventory.dto.InventoryResponse;
import net.luculent.trenddbmanage.common.model.PageResult;

/**
 * 库存统计 Service 接口
 * 提供查询仓库库存的服务
 *
 * @author shangye
 * @date 2025-06-28
 */
public interface InventoryService {

    /**
     * 分页查询库存信息（可按仓库名称和物品名称模糊筛选）
     * @param request 查询请求参数
     * @return 分页库存结果
     */
    PageResult<InventoryResponse> queryInventory(InventoryQueryRequest request);
}
