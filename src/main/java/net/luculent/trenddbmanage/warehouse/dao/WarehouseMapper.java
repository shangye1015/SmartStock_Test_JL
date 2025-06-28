package net.luculent.trenddbmanage.warehouse.dao;


import net.luculent.trenddbmanage.warehouse.entity.Warehouse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WarehouseMapper {

    void insertWarehouse(Warehouse warehouse);

    void updateWarehouse(Warehouse warehouse);

    void deleteWarehouseById(@Param("id") Integer id);

    Warehouse selectById(@Param("id") Integer id);

    List<Warehouse> selectListByConditions(@Param("code") String code,
                                           @Param("name") String name,
                                           @Param("manager") String manager,
                                           @Param("offset") Integer offset,
                                           @Param("size") Integer size);

    int countByConditions(@Param("code") String code,
                          @Param("name") String name,
                          @Param("manager") String manager);
}

