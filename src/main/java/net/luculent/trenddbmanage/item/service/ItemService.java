package net.luculent.trenddbmanage.item.service;

import net.luculent.trenddbmanage.common.model.PageResult;
import net.luculent.trenddbmanage.item.dto.*;

import java.util.List;

import net.luculent.trenddbmanage.item.dto.*;

/**
 * 物品管理服务接口
 * 定义物品模块的业务操作规范
 *
 * @author shangye
 * @date 2025-06-28
 */
public interface ItemService {

    /**
     * 新增物品
     * @param req 物品创建请求参数
     */
    void createItem(ItemCreateRequest req);

    /**
     * 更新物品信息
     * @param req 物品更新请求参数，必须包含ID
     */
    void updateItem(ItemUpdateRequest req);

    /**
     * 根据ID删除物品
     * @param id 物品ID
     */
    void deleteItem(Integer id);

    /**
     * 根据ID查询物品详情
     * @param id 物品ID
     * @return 物品详情响应对象，若无则返回null
     */
    ItemResponse getItemById(Integer id);

    /**
     * 分页条件查询物品列表，支持名称模糊及分类筛选
     * @param req 查询请求参数，包含分页和筛选条件
     * @return 物品分页列表结果
     */
    PageResult<ItemResponse> queryItems(ItemQueryRequest req);
}

