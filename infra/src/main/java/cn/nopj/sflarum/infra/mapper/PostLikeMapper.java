package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.PostLikePo;
import cn.nopj.sflarum.domian.entity.key.PostLikeKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface PostLikeMapper {
    @Select("SELECT `post_id` AS postId, `user_id` AS userId, `created_at` AS createdAt FROM `f_post_likes` WHERE `post_id` = #{postId} AND `user_id` = #{userId}")
    PostLikePo findById(PostLikeKey key);
    @Select("SELECT `post_id` AS postId, `user_id` AS userId, `created_at` AS createdAt FROM `f_post_likes`")
    List<PostLikePo> findAll();
    @Insert("INSERT INTO `f_post_likes` (`post_id`, `user_id`, `created_at`) VALUES (#{postId}, #{userId}, #{createdAt})")
    int insert(PostLikePo po);
    @Update("UPDATE `f_post_likes` SET `post_id` = #{postId}, `user_id` = #{userId}, `created_at` = #{createdAt} WHERE `post_id` = #{postId} AND `user_id` = #{userId}")
    int update(PostLikePo po);
    @Delete("DELETE FROM `f_post_likes` WHERE `post_id` = #{postId} AND `user_id` = #{userId}")
    int deleteById(PostLikeKey key);
}