package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.TagPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface TagMapper {
    @Select("SELECT `id` AS id, `name` AS name, `slug` AS slug, `description` AS description, `color` AS color, `image_url` AS imageUrl, `background_path` AS backgroundPath, `background_mode` AS backgroundMode, `position` AS position, `parent_id` AS parentId, `default_sort` AS defaultSort, `is_restricted` AS isRestricted, `is_hidden` AS isHidden, `discussion_count` AS discussionCount, `last_posted_at` AS lastPostedAt, `last_posted_discussion_id` AS lastPostedDiscussionId, `last_posted_user_id` AS lastPostedUserId, `icon` AS icon, `created_at` AS createdAt, `updated_at` AS updatedAt, `post_count` AS postCount, `is_qna` AS isQna, `qna_reminders` AS qnaReminders FROM `f_tags` WHERE `id` = #{id}")
    TagPo findById(Long id);
    @Select("SELECT `id` AS id, `name` AS name, `slug` AS slug, `description` AS description, `color` AS color, `image_url` AS imageUrl, `background_path` AS backgroundPath, `background_mode` AS backgroundMode, `position` AS position, `parent_id` AS parentId, `default_sort` AS defaultSort, `is_restricted` AS isRestricted, `is_hidden` AS isHidden, `discussion_count` AS discussionCount, `last_posted_at` AS lastPostedAt, `last_posted_discussion_id` AS lastPostedDiscussionId, `last_posted_user_id` AS lastPostedUserId, `icon` AS icon, `created_at` AS createdAt, `updated_at` AS updatedAt, `post_count` AS postCount, `is_qna` AS isQna, `qna_reminders` AS qnaReminders FROM `f_tags`")
    List<TagPo> findAll();
    @Insert("INSERT INTO `f_tags` (`id`, `name`, `slug`, `description`, `color`, `image_url`, `background_path`, `background_mode`, `position`, `parent_id`, `default_sort`, `is_restricted`, `is_hidden`, `discussion_count`, `last_posted_at`, `last_posted_discussion_id`, `last_posted_user_id`, `icon`, `created_at`, `updated_at`, `post_count`, `is_qna`, `qna_reminders`) VALUES (#{id}, #{name}, #{slug}, #{description}, #{color}, #{imageUrl}, #{backgroundPath}, #{backgroundMode}, #{position}, #{parentId}, #{defaultSort}, #{isRestricted}, #{isHidden}, #{discussionCount}, #{lastPostedAt}, #{lastPostedDiscussionId}, #{lastPostedUserId}, #{icon}, #{createdAt}, #{updatedAt}, #{postCount}, #{isQna}, #{qnaReminders})")
    int insert(TagPo po);
    @Update("UPDATE `f_tags` SET `id` = #{id}, `name` = #{name}, `slug` = #{slug}, `description` = #{description}, `color` = #{color}, `image_url` = #{imageUrl}, `background_path` = #{backgroundPath}, `background_mode` = #{backgroundMode}, `position` = #{position}, `parent_id` = #{parentId}, `default_sort` = #{defaultSort}, `is_restricted` = #{isRestricted}, `is_hidden` = #{isHidden}, `discussion_count` = #{discussionCount}, `last_posted_at` = #{lastPostedAt}, `last_posted_discussion_id` = #{lastPostedDiscussionId}, `last_posted_user_id` = #{lastPostedUserId}, `icon` = #{icon}, `created_at` = #{createdAt}, `updated_at` = #{updatedAt}, `post_count` = #{postCount}, `is_qna` = #{isQna}, `qna_reminders` = #{qnaReminders} WHERE `id` = #{id}")
    int update(TagPo po);
    @Delete("DELETE FROM `f_tags` WHERE `id` = #{id}")
    int deleteById(Long id);
}