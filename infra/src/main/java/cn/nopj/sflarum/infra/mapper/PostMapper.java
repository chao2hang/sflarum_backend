package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.PostPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface PostMapper {
    @Select("SELECT `id` AS id, `discussion_id` AS discussionId, `number` AS number, `created_at` AS createdAt, `user_id` AS userId, `type` AS type, `content` AS content, `edited_at` AS editedAt, `edited_user_id` AS editedUserId, `hidden_at` AS hiddenAt, `hidden_user_id` AS hiddenUserId, `ip_address` AS ipAddress, `is_private` AS isPrivate, `is_approved` AS isApproved FROM `f_posts` WHERE `id` = #{id}")
    PostPo findById(Long id);
    @Select("SELECT `id` AS id, `discussion_id` AS discussionId, `number` AS number, `created_at` AS createdAt, `user_id` AS userId, `type` AS type, `content` AS content, `edited_at` AS editedAt, `edited_user_id` AS editedUserId, `hidden_at` AS hiddenAt, `hidden_user_id` AS hiddenUserId, `ip_address` AS ipAddress, `is_private` AS isPrivate, `is_approved` AS isApproved FROM `f_posts`")
    List<PostPo> findAll();
    @Insert("INSERT INTO `f_posts` (`id`, `discussion_id`, `number`, `created_at`, `user_id`, `type`, `content`, `edited_at`, `edited_user_id`, `hidden_at`, `hidden_user_id`, `ip_address`, `is_private`, `is_approved`) VALUES (#{id}, #{discussionId}, #{number}, #{createdAt}, #{userId}, #{type}, #{content}, #{editedAt}, #{editedUserId}, #{hiddenAt}, #{hiddenUserId}, #{ipAddress}, #{isPrivate}, #{isApproved})")
    int insert(PostPo po);
    @Update("UPDATE `f_posts` SET `id` = #{id}, `discussion_id` = #{discussionId}, `number` = #{number}, `created_at` = #{createdAt}, `user_id` = #{userId}, `type` = #{type}, `content` = #{content}, `edited_at` = #{editedAt}, `edited_user_id` = #{editedUserId}, `hidden_at` = #{hiddenAt}, `hidden_user_id` = #{hiddenUserId}, `ip_address` = #{ipAddress}, `is_private` = #{isPrivate}, `is_approved` = #{isApproved} WHERE `id` = #{id}")
    int update(PostPo po);
    @Delete("DELETE FROM `f_posts` WHERE `id` = #{id}")
    int deleteById(Long id);
}