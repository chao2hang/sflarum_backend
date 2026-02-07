package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.PostMentionTagPo;
import cn.nopj.sflarum.domian.entity.key.PostMentionTagKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface PostMentionTagMapper {
    @Select("SELECT `post_id` AS postId, `mentions_tag_id` AS mentionsTagId, `created_at` AS createdAt FROM `f_post_mentions_tag` WHERE `post_id` = #{postId} AND `mentions_tag_id` = #{mentionsTagId}")
    PostMentionTagPo findById(PostMentionTagKey key);
    @Select("SELECT `post_id` AS postId, `mentions_tag_id` AS mentionsTagId, `created_at` AS createdAt FROM `f_post_mentions_tag`")
    List<PostMentionTagPo> findAll();
    @Insert("INSERT INTO `f_post_mentions_tag` (`post_id`, `mentions_tag_id`, `created_at`) VALUES (#{postId}, #{mentionsTagId}, #{createdAt})")
    int insert(PostMentionTagPo po);
    @Update("UPDATE `f_post_mentions_tag` SET `post_id` = #{postId}, `mentions_tag_id` = #{mentionsTagId}, `created_at` = #{createdAt} WHERE `post_id` = #{postId} AND `mentions_tag_id` = #{mentionsTagId}")
    int update(PostMentionTagPo po);
    @Delete("DELETE FROM `f_post_mentions_tag` WHERE `post_id` = #{postId} AND `mentions_tag_id` = #{mentionsTagId}")
    int deleteById(PostMentionTagKey key);
}