package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.GroupUserPo;
import cn.nopj.sflarum.domian.entity.key.GroupUserKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface GroupUserMapper {
    @Select("SELECT `user_id` AS userId, `group_id` AS groupId, `created_at` AS createdAt FROM `f_group_user` WHERE `user_id` = #{userId} AND `group_id` = #{groupId}")
    GroupUserPo findById(GroupUserKey key);
    @Select("SELECT `user_id` AS userId, `group_id` AS groupId, `created_at` AS createdAt FROM `f_group_user`")
    List<GroupUserPo> findAll();
    @Insert("INSERT INTO `f_group_user` (`user_id`, `group_id`, `created_at`) VALUES (#{userId}, #{groupId}, #{createdAt})")
    int insert(GroupUserPo po);
    @Update("UPDATE `f_group_user` SET `user_id` = #{userId}, `group_id` = #{groupId}, `created_at` = #{createdAt} WHERE `user_id` = #{userId} AND `group_id` = #{groupId}")
    int update(GroupUserPo po);
    @Delete("DELETE FROM `f_group_user` WHERE `user_id` = #{userId} AND `group_id` = #{groupId}")
    int deleteById(GroupUserKey key);
}