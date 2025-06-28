package net.luculent.trenddbmanage.warehouse.service;

import net.luculent.trenddbmanage.common.model.PageResult;
import net.luculent.trenddbmanage.warehouse.dto.*;

/**
 * 仓库服务接口
 *
 * 提供仓库相关的业务操作，包括创建、修改、删除及分页查询。
 * 接口方法通常由 Service 实现类实现，并由 Controller 层调用。
 */
public interface WarehouseService {

    /**
     * 创建新的仓库
     *
     * @param request 包含仓库创建信息的请求对象
     */
    void createWarehouse(WarehouseCreateRequest request);

    /**
     * 更新已有仓库的信息
     *
     * @param request 包含待更新字段和仓库 ID 的请求对象
     */
    void updateWarehouse(WarehouseUpdateRequest request);

    /**
     * 删除指定的仓库
     *
     * @param request 包含仓库 ID 的请求对象
     */
    void deleteWarehouse(WarehouseDeleteRequest request);

    /**
     * 多条件分页查询仓库列表
     *
     * @param request 包含查询条件和分页参数的请求对象
     * @return 分页结果，包含仓库响应对象列表及总条数
     */
    PageResult<WarehouseResponse> queryWarehouses(WarehouseQueryRequest request);
}
