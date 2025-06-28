package net.luculent.trenddbmanage.item.service.impl;

import lombok.RequiredArgsConstructor;
import net.luculent.trenddbmanage.common.model.PageResult;
import net.luculent.trenddbmanage.item.dao.ItemMapper;
import net.luculent.trenddbmanage.item.dto.*;
import net.luculent.trenddbmanage.item.entity.Item;
import net.luculent.trenddbmanage.item.service.ItemService;
import org.springframework.stereotype.Service;
import cn.hutool.core.bean.BeanUtil;

import java.util.List;
import java.util.stream.Collectors;


/**
 * 物品管理服务实现类
 * 负责业务逻辑处理和数据库操作封装
 *
 * @author shangye
 * @date 2025-06-28
 */
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemMapper itemMapper;

    /**
     * 新增物品，默认状态为启用
     *
     * @param req 物品创建请求对象
     */
    @Override
    public void createItem(ItemCreateRequest req) {
        Item item = BeanUtil.copyProperties(req, Item.class);
        item.setStatus(1); // 默认启用状态
        itemMapper.insert(item);
    }

    /**
     * 根据ID更新物品信息，支持动态更新非空字段
     *
     * @param req 物品更新请求对象，必须包含ID
     */
    @Override
    public void updateItem(ItemUpdateRequest req) {
        Item item = BeanUtil.copyProperties(req, Item.class);
        itemMapper.update(item);
    }

    /**
     * 根据ID删除物品，执行物理删除
     *
     * @param id 物品ID
     */
    @Override
    public void deleteItem(Integer id) {
        itemMapper.deleteById(id);
    }

    /**
     * 根据ID查询物品详情
     *
     * @param id 物品ID
     * @return 物品详情DTO，若不存在返回null
     */
    @Override
    public ItemResponse getItemById(Integer id) {
        Item item = itemMapper.selectById(id);
        if (item == null) {
            return null;
        }
        return BeanUtil.copyProperties(item, ItemResponse.class);
    }

    /**
     * 分页条件查询物品列表，支持名称模糊匹配及分类筛选
     *
     * @param req 查询条件和分页参数
     * @return 分页结果封装，包含总条数和当前页列表
     */
    @Override
    public PageResult<ItemResponse> queryItems(ItemQueryRequest req) {
        int offset = (req.getPage() - 1) * req.getSize();
        List<Item> list = itemMapper.selectByNameAndCategory(req.getName(), req.getCategoryId(), offset, req.getSize());
        int total = itemMapper.countByNameAndCategory(req.getName(), req.getCategoryId());

        List<ItemResponse> records = list.stream()
                .map(item -> BeanUtil.copyProperties(item, ItemResponse.class))
                .collect(Collectors.toList());

        return new PageResult<>(total, records);
    }
}
