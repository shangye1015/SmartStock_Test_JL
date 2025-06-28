package net.luculent.trenddbmanage.warehouseflow.dao;


import net.luculent.trenddbmanage.warehouseflow.entity.InventoryOrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单物品明细
 */
@Mapper
public interface InventoryOrderItemMapper {

    int insert(InventoryOrderItem item);

    int deleteByOrderId(@Param("orderId") Integer orderId);

    List<InventoryOrderItem> selectByOrderId(@Param("orderId") Integer orderId);
}

