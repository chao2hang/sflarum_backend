package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.DiscussionUserPo;
import cn.nopj.sflarum.domian.entity.key.DiscussionUserKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface DiscussionUserMapper {
    @Select("SELECT `user_id` AS userId, `discussion_id` AS discussionId, `last_read_at` AS lastReadAt, `last_read_post_number` AS lastReadPostNumber, `subscription` AS subscription FROM `f_discussion_user` WHERE `user_id` = #{userId} AND `discussion_id` = #{discussionId}")
    DiscussionUserPo findById(DiscussionUserKey key);
    @Select("SELECT `user_id` AS userId, `discussion_id` AS discussionId, `last_read_at` AS lastReadAt, `last_read_post_number` AS lastReadPostNumber, `subscription` AS subscription FROM `f_discussion_user`")
    List<DiscussionUserPo> findAll();
    @Insert("INSERT INTO `f_discussion_user` (`user_id`, `discussion_id`, `last_read_at`, `last_read_post_number`, `subscription`) VALUES (#{userId}, #{discussionId}, #{lastReadAt}, #{lastReadPostNumber}, #{subscription})")
    int insert(DiscussionUserPo po);
    @Update("UPDATE `f_discussion_user` SET `user_id` = #{userId}, `discussion_id` = #{discussionId}, `last_read_at` = #{lastReadAt}, `last_read_post_number` = #{lastReadPostNumber}, `subscription` = #{subscription} WHERE `user_id` = #{userId} AND `discussion_id` = #{discussionId}")
    int update(DiscussionUserPo po);
    @Delete("DELETE FROM `f_discussion_user` WHERE `user_id` = #{userId} AND `discussion_id` = #{discussionId}")
    int deleteById(DiscussionUserKey key);
}