package net.luculent.trenddbmanage.warehouseflow.dao;

import net.luculent.trenddbmanage.warehouseflow.entity.InventoryOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单信息
 */
@Mapper
public interface InventoryOrderMapper {

    int insert(InventoryOrder order);
    Integer selectLastInsertId();

    int update(InventoryOrder order);

    int deleteById(Integer id);

    InventoryOrder selectById(Integer id);

    List<InventoryOrder> selectAll();

    int updateStatus(@Param("id") Integer id, @Param("status") String status);

}

