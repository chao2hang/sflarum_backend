package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.DiscussionTagPo;
import cn.nopj.sflarum.domian.entity.key.DiscussionTagKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface DiscussionTagMapper {
    @Select("SELECT `discussion_id` AS discussionId, `tag_id` AS tagId, `created_at` AS createdAt FROM `f_discussion_tag` WHERE `discussion_id` = #{discussionId} AND `tag_id` = #{tagId}")
    DiscussionTagPo findById(DiscussionTagKey key);
    @Select("SELECT `discussion_id` AS discussionId, `tag_id` AS tagId, `created_at` AS createdAt FROM `f_discussion_tag`")
    List<DiscussionTagPo> findAll();
    @Insert("INSERT INTO `f_discussion_tag` (`discussion_id`, `tag_id`, `created_at`) VALUES (#{discussionId}, #{tagId}, #{createdAt})")
    int insert(DiscussionTagPo po);
    @Update("UPDATE `f_discussion_tag` SET `discussion_id` = #{discussionId}, `tag_id` = #{tagId}, `created_at` = #{createdAt} WHERE `discussion_id` = #{discussionId} AND `tag_id` = #{tagId}")
    int update(DiscussionTagPo po);
    @Delete("DELETE FROM `f_discussion_tag` WHERE `discussion_id` = #{discussionId} AND `tag_id` = #{tagId}")
    int deleteById(DiscussionTagKey key);
}