package net.luculent.trenddbmanage.warehouse.service;


import net.luculent.trenddbmanage.utils.PageResult;
import net.luculent.trenddbmanage.warehouse.dto.*;

public interface WarehouseService {
    void createWarehouse(WarehouseCreateRequest request);

    void updateWarehouse(WarehouseUpdateRequest request);

    void deleteWarehouse(WarehouseDeleteRequest request);

    PageResult<WarehouseResponse> queryWarehouses(WarehouseQueryRequest request);
}

