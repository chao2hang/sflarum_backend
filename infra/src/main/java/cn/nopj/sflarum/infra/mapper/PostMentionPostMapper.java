package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.PostMentionPostPo;
import cn.nopj.sflarum.domian.entity.key.PostMentionPostKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface PostMentionPostMapper {
    @Select("SELECT `post_id` AS postId, `mentions_post_id` AS mentionsPostId, `created_at` AS createdAt FROM `f_post_mentions_post` WHERE `post_id` = #{postId} AND `mentions_post_id` = #{mentionsPostId}")
    PostMentionPostPo findById(PostMentionPostKey key);
    @Select("SELECT `post_id` AS postId, `mentions_post_id` AS mentionsPostId, `created_at` AS createdAt FROM `f_post_mentions_post`")
    List<PostMentionPostPo> findAll();
    @Insert("INSERT INTO `f_post_mentions_post` (`post_id`, `mentions_post_id`, `created_at`) VALUES (#{postId}, #{mentionsPostId}, #{createdAt})")
    int insert(PostMentionPostPo po);
    @Update("UPDATE `f_post_mentions_post` SET `post_id` = #{postId}, `mentions_post_id` = #{mentionsPostId}, `created_at` = #{createdAt} WHERE `post_id` = #{postId} AND `mentions_post_id` = #{mentionsPostId}")
    int update(PostMentionPostPo po);
    @Delete("DELETE FROM `f_post_mentions_post` WHERE `post_id` = #{postId} AND `mentions_post_id` = #{mentionsPostId}")
    int deleteById(PostMentionPostKey key);
}