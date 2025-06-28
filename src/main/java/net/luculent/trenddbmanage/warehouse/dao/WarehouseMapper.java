package net.luculent.trenddbmanage.warehouse.dao;

import net.luculent.trenddbmanage.warehouse.entity.Warehouse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 仓库数据访问层（DAO）
 *
 * 负责操作仓库相关的数据库表，包括新增、更新、删除、查询、分页等
 */
@Mapper
public interface WarehouseMapper {

    /**
     * 新增仓库记录
     *
     * @param warehouse 仓库实体对象
     */
    void insertWarehouse(Warehouse warehouse);

    /**
     * 根据主键 ID 更新仓库记录
     *
     * @param warehouse 包含更新信息的仓库实体（必须包含 id）
     */
    void updateWarehouse(Warehouse warehouse);

    /**
     * 根据主键 ID 删除仓库记录
     *
     * @param id 仓库 ID
     */
    void deleteWarehouseById(@Param("id") Integer id);

    /**
     * 根据主键 ID 查询仓库详情
     *
     * @param id 仓库 ID
     * @return 查询到的仓库对象（可能为 null）
     */
    Warehouse selectById(@Param("id") Integer id);

    /**
     * 多条件分页查询仓库列表
     *
     * @param code    仓库编号（可选模糊查询）
     * @param name    仓库名称（可选模糊查询）
     * @param manager 负责人姓名（可选模糊查询）
     * @param offset  起始记录数
     * @param size    返回记录数
     * @return 仓库列表
     */
    List<Warehouse> selectListByConditions(@Param("code") String code,
                                           @Param("name") String name,
                                           @Param("manager") String manager,
                                           @Param("offset") Integer offset,
                                           @Param("size") Integer size);

    /**
     * 统计符合条件的仓库数量（用于分页总数）
     *
     * @param code    仓库编号（可选）
     * @param name    仓库名称（可选）
     * @param manager 负责人（可选）
     * @return 记录数量
     */
    int countByConditions(@Param("code") String code,
                          @Param("name") String name,
                          @Param("manager") String manager);
}
