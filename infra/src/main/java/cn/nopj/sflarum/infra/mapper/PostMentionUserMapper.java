package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.PostMentionUserPo;
import cn.nopj.sflarum.domian.entity.key.PostMentionUserKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface PostMentionUserMapper {
    @Select("SELECT `post_id` AS postId, `mentions_user_id` AS mentionsUserId, `created_at` AS createdAt FROM `f_post_mentions_user` WHERE `post_id` = #{postId} AND `mentions_user_id` = #{mentionsUserId}")
    PostMentionUserPo findById(PostMentionUserKey key);
    @Select("SELECT `post_id` AS postId, `mentions_user_id` AS mentionsUserId, `created_at` AS createdAt FROM `f_post_mentions_user`")
    List<PostMentionUserPo> findAll();
    @Insert("INSERT INTO `f_post_mentions_user` (`post_id`, `mentions_user_id`, `created_at`) VALUES (#{postId}, #{mentionsUserId}, #{createdAt})")
    int insert(PostMentionUserPo po);
    @Update("UPDATE `f_post_mentions_user` SET `post_id` = #{postId}, `mentions_user_id` = #{mentionsUserId}, `created_at` = #{createdAt} WHERE `post_id` = #{postId} AND `mentions_user_id` = #{mentionsUserId}")
    int update(PostMentionUserPo po);
    @Delete("DELETE FROM `f_post_mentions_user` WHERE `post_id` = #{postId} AND `mentions_user_id` = #{mentionsUserId}")
    int deleteById(PostMentionUserKey key);
}