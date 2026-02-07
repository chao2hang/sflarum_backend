package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.DiscussionViewPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface DiscussionViewMapper {
    @Select("SELECT `id` AS id, `user_id` AS userId, `discussion_id` AS discussionId, `ip` AS ip, `visited_at` AS visitedAt FROM `f_discussion_views` WHERE `id` = #{id}")
    DiscussionViewPo findById(Long id);
    @Select("SELECT `id` AS id, `user_id` AS userId, `discussion_id` AS discussionId, `ip` AS ip, `visited_at` AS visitedAt FROM `f_discussion_views`")
    List<DiscussionViewPo> findAll();
    @Insert("INSERT INTO `f_discussion_views` (`id`, `user_id`, `discussion_id`, `ip`, `visited_at`) VALUES (#{id}, #{userId}, #{discussionId}, #{ip}, #{visitedAt})")
    int insert(DiscussionViewPo po);
    @Update("UPDATE `f_discussion_views` SET `id` = #{id}, `user_id` = #{userId}, `discussion_id` = #{discussionId}, `ip` = #{ip}, `visited_at` = #{visitedAt} WHERE `id` = #{id}")
    int update(DiscussionViewPo po);
    @Delete("DELETE FROM `f_discussion_views` WHERE `id` = #{id}")
    int deleteById(Long id);
}