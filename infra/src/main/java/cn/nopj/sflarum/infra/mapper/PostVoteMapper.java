package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.PostVotePo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface PostVoteMapper {
    @Select("SELECT `id` AS id, `post_id` AS postId, `user_id` AS userId, `value` AS value, `created_at` AS createdAt, `updated_at` AS updatedAt FROM `f_post_votes` WHERE `id` = #{id}")
    PostVotePo findById(Long id);
    @Select("SELECT `id` AS id, `post_id` AS postId, `user_id` AS userId, `value` AS value, `created_at` AS createdAt, `updated_at` AS updatedAt FROM `f_post_votes`")
    List<PostVotePo> findAll();
    @Insert("INSERT INTO `f_post_votes` (`id`, `post_id`, `user_id`, `value`, `created_at`, `updated_at`) VALUES (#{id}, #{postId}, #{userId}, #{value}, #{createdAt}, #{updatedAt})")
    int insert(PostVotePo po);
    @Update("UPDATE `f_post_votes` SET `id` = #{id}, `post_id` = #{postId}, `user_id` = #{userId}, `value` = #{value}, `created_at` = #{createdAt}, `updated_at` = #{updatedAt} WHERE `id` = #{id}")
    int update(PostVotePo po);
    @Delete("DELETE FROM `f_post_votes` WHERE `id` = #{id}")
    int deleteById(Long id);
}