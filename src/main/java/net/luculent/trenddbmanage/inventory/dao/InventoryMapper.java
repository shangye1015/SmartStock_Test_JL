package net.luculent.trenddbmanage.inventory.dao;

import net.luculent.trenddbmanage.inventory.dto.InventoryResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 库存 Mapper 接口
 * 提供库存明细的查询和统计方法
 */
@Mapper
public interface InventoryMapper {

    /**
     * 分页查询库存明细列表
     *
     * @param warehouseName 仓库名称（模糊查询）
     * @param itemName      物品名称（模糊查询）
     * @param offset        分页偏移量
     * @param limit         每页条数
     * @return 库存响应列表
     */
    List<InventoryResponse> selectInventory(
            @Param("warehouseName") String warehouseName,
            @Param("itemName") String itemName,
            @Param("offset") int offset,
            @Param("limit") int limit
    );

    /**
     * 查询库存明细总数量（用于分页）
     *
     * @param warehouseName 仓库名称（模糊查询）
     * @param itemName      物品名称（模糊查询）
     * @return 总记录数
     */
    int countInventory(
            @Param("warehouseName") String warehouseName,
            @Param("itemName") String itemName
    );
}
