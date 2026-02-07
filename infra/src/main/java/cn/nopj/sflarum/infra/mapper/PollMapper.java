package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.PollPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface PollMapper {
    @Select("SELECT `id` AS id, `question` AS question, `subtitle` AS subtitle, `image` AS image, `image_alt` AS imageAlt, `post_id` AS postId, `user_id` AS userId, `public_poll` AS publicPoll, `end_date` AS endDate, `created_at` AS createdAt, `updated_at` AS updatedAt, `vote_count` AS voteCount, `allow_multiple_votes` AS allowMultipleVotes, `max_votes` AS maxVotes, `settings` AS settings FROM `f_polls` WHERE `id` = #{id}")
    PollPo findById(Long id);
    @Select("SELECT `id` AS id, `question` AS question, `subtitle` AS subtitle, `image` AS image, `image_alt` AS imageAlt, `post_id` AS postId, `user_id` AS userId, `public_poll` AS publicPoll, `end_date` AS endDate, `created_at` AS createdAt, `updated_at` AS updatedAt, `vote_count` AS voteCount, `allow_multiple_votes` AS allowMultipleVotes, `max_votes` AS maxVotes, `settings` AS settings FROM `f_polls`")
    List<PollPo> findAll();
    @Insert("INSERT INTO `f_polls` (`id`, `question`, `subtitle`, `image`, `image_alt`, `post_id`, `user_id`, `public_poll`, `end_date`, `created_at`, `updated_at`, `vote_count`, `allow_multiple_votes`, `max_votes`, `settings`) VALUES (#{id}, #{question}, #{subtitle}, #{image}, #{imageAlt}, #{postId}, #{userId}, #{publicPoll}, #{endDate}, #{createdAt}, #{updatedAt}, #{voteCount}, #{allowMultipleVotes}, #{maxVotes}, #{settings})")
    int insert(PollPo po);
    @Update("UPDATE `f_polls` SET `id` = #{id}, `question` = #{question}, `subtitle` = #{subtitle}, `image` = #{image}, `image_alt` = #{imageAlt}, `post_id` = #{postId}, `user_id` = #{userId}, `public_poll` = #{publicPoll}, `end_date` = #{endDate}, `created_at` = #{createdAt}, `updated_at` = #{updatedAt}, `vote_count` = #{voteCount}, `allow_multiple_votes` = #{allowMultipleVotes}, `max_votes` = #{maxVotes}, `settings` = #{settings} WHERE `id` = #{id}")
    int update(PollPo po);
    @Delete("DELETE FROM `f_polls` WHERE `id` = #{id}")
    int deleteById(Long id);
}