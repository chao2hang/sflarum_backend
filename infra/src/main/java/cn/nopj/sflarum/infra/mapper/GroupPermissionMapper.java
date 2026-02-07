package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.GroupPermissionPo;
import cn.nopj.sflarum.domian.entity.key.GroupPermissionKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface GroupPermissionMapper {
    @Select("SELECT `group_id` AS groupId, `permission` AS permission, `created_at` AS createdAt FROM `f_group_permission` WHERE `group_id` = #{groupId} AND `permission` = #{permission}")
    GroupPermissionPo findById(GroupPermissionKey key);
    @Select("SELECT `group_id` AS groupId, `permission` AS permission, `created_at` AS createdAt FROM `f_group_permission`")
    List<GroupPermissionPo> findAll();
    @Insert("INSERT INTO `f_group_permission` (`group_id`, `permission`, `created_at`) VALUES (#{groupId}, #{permission}, #{createdAt})")
    int insert(GroupPermissionPo po);
    @Update("UPDATE `f_group_permission` SET `group_id` = #{groupId}, `permission` = #{permission}, `created_at` = #{createdAt} WHERE `group_id` = #{groupId} AND `permission` = #{permission}")
    int update(GroupPermissionPo po);
    @Delete("DELETE FROM `f_group_permission` WHERE `group_id` = #{groupId} AND `permission` = #{permission}")
    int deleteById(GroupPermissionKey key);
}