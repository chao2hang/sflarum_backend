package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.PostUserPo;
import cn.nopj.sflarum.domian.entity.key.PostUserKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface PostUserMapper {
    @Select("SELECT `post_id` AS postId, `user_id` AS userId FROM `f_post_user` WHERE `post_id` = #{postId} AND `user_id` = #{userId}")
    PostUserPo findById(PostUserKey key);
    @Select("SELECT `post_id` AS postId, `user_id` AS userId FROM `f_post_user`")
    List<PostUserPo> findAll();
    @Insert("INSERT INTO `f_post_user` (`post_id`, `user_id`) VALUES (#{postId}, #{userId})")
    int insert(PostUserPo po);
    @Update("UPDATE `f_post_user` SET `post_id` = #{postId}, `user_id` = #{userId} WHERE `post_id` = #{postId} AND `user_id` = #{userId}")
    int update(PostUserPo po);
    @Delete("DELETE FROM `f_post_user` WHERE `post_id` = #{postId} AND `user_id` = #{userId}")
    int deleteById(PostUserKey key);
}