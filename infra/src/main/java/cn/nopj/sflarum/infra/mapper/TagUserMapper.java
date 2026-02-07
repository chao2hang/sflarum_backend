package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.TagUserPo;
import cn.nopj.sflarum.domian.entity.key.TagUserKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface TagUserMapper {
    @Select("SELECT `user_id` AS userId, `tag_id` AS tagId, `marked_as_read_at` AS markedAsReadAt, `is_hidden` AS isHidden, `subscription` AS subscription, `created_at` AS createdAt, `updated_at` AS updatedAt FROM `f_tag_user` WHERE `user_id` = #{userId} AND `tag_id` = #{tagId}")
    TagUserPo findById(TagUserKey key);
    @Select("SELECT `user_id` AS userId, `tag_id` AS tagId, `marked_as_read_at` AS markedAsReadAt, `is_hidden` AS isHidden, `subscription` AS subscription, `created_at` AS createdAt, `updated_at` AS updatedAt FROM `f_tag_user`")
    List<TagUserPo> findAll();
    @Insert("INSERT INTO `f_tag_user` (`user_id`, `tag_id`, `marked_as_read_at`, `is_hidden`, `subscription`, `created_at`, `updated_at`) VALUES (#{userId}, #{tagId}, #{markedAsReadAt}, #{isHidden}, #{subscription}, #{createdAt}, #{updatedAt})")
    int insert(TagUserPo po);
    @Update("UPDATE `f_tag_user` SET `user_id` = #{userId}, `tag_id` = #{tagId}, `marked_as_read_at` = #{markedAsReadAt}, `is_hidden` = #{isHidden}, `subscription` = #{subscription}, `created_at` = #{createdAt}, `updated_at` = #{updatedAt} WHERE `user_id` = #{userId} AND `tag_id` = #{tagId}")
    int update(TagUserPo po);
    @Delete("DELETE FROM `f_tag_user` WHERE `user_id` = #{userId} AND `tag_id` = #{tagId}")
    int deleteById(TagUserKey key);
}