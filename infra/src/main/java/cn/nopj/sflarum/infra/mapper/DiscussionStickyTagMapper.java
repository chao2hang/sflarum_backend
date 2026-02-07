package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.DiscussionStickyTagPo;
import cn.nopj.sflarum.domian.entity.key.DiscussionStickyTagKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface DiscussionStickyTagMapper {
    @Select("SELECT `discussion_id` AS discussionId, `tag_id` AS tagId FROM `f_discussion_sticky_tag` WHERE `discussion_id` = #{discussionId} AND `tag_id` = #{tagId}")
    DiscussionStickyTagPo findById(DiscussionStickyTagKey key);
    @Select("SELECT `discussion_id` AS discussionId, `tag_id` AS tagId FROM `f_discussion_sticky_tag`")
    List<DiscussionStickyTagPo> findAll();
    @Insert("INSERT INTO `f_discussion_sticky_tag` (`discussion_id`, `tag_id`) VALUES (#{discussionId}, #{tagId})")
    int insert(DiscussionStickyTagPo po);
    @Update("UPDATE `f_discussion_sticky_tag` SET `discussion_id` = #{discussionId}, `tag_id` = #{tagId} WHERE `discussion_id` = #{discussionId} AND `tag_id` = #{tagId}")
    int update(DiscussionStickyTagPo po);
    @Delete("DELETE FROM `f_discussion_sticky_tag` WHERE `discussion_id` = #{discussionId} AND `tag_id` = #{tagId}")
    int deleteById(DiscussionStickyTagKey key);
}