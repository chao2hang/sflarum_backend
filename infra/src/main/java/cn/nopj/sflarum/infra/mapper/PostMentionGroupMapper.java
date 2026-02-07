package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.PostMentionGroupPo;
import cn.nopj.sflarum.domian.entity.key.PostMentionGroupKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface PostMentionGroupMapper {
    @Select("SELECT `post_id` AS postId, `mentions_group_id` AS mentionsGroupId, `created_at` AS createdAt FROM `f_post_mentions_group` WHERE `post_id` = #{postId} AND `mentions_group_id` = #{mentionsGroupId}")
    PostMentionGroupPo findById(PostMentionGroupKey key);
    @Select("SELECT `post_id` AS postId, `mentions_group_id` AS mentionsGroupId, `created_at` AS createdAt FROM `f_post_mentions_group`")
    List<PostMentionGroupPo> findAll();
    @Insert("INSERT INTO `f_post_mentions_group` (`post_id`, `mentions_group_id`, `created_at`) VALUES (#{postId}, #{mentionsGroupId}, #{createdAt})")
    int insert(PostMentionGroupPo po);
    @Update("UPDATE `f_post_mentions_group` SET `post_id` = #{postId}, `mentions_group_id` = #{mentionsGroupId}, `created_at` = #{createdAt} WHERE `post_id` = #{postId} AND `mentions_group_id` = #{mentionsGroupId}")
    int update(PostMentionGroupPo po);
    @Delete("DELETE FROM `f_post_mentions_group` WHERE `post_id` = #{postId} AND `mentions_group_id` = #{mentionsGroupId}")
    int deleteById(PostMentionGroupKey key);
}