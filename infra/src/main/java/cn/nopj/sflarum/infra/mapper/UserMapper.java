package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.UserPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface UserMapper {
    @Select("SELECT `id` AS id, `username` AS username, `nickname` AS nickname, `email` AS email, `is_email_confirmed` AS isEmailConfirmed, `password` AS password, `avatar_url` AS avatarUrl, `preferences` AS preferences, `joined_at` AS joinedAt, `last_seen_at` AS lastSeenAt, `marked_all_as_read_at` AS markedAllAsReadAt, `read_notifications_at` AS readNotificationsAt, `discussion_count` AS discussionCount, `comment_count` AS commentCount, `read_flags_at` AS readFlagsAt, `suspended_until` AS suspendedUntil, `suspend_reason` AS suspendReason, `suspend_message` AS suspendMessage, `money` AS money, `best_answer_count` AS bestAnswerCount, `votes` AS votes, `rank` AS rank, `last_vote_time` AS lastVoteTime, `bio` AS bio, `cover` AS cover FROM `f_users` WHERE `id` = #{id}")
    UserPo findById(Long id);
    @Select("SELECT `id` AS id, `username` AS username, `nickname` AS nickname, `email` AS email, `is_email_confirmed` AS isEmailConfirmed, `password` AS password, `avatar_url` AS avatarUrl, `preferences` AS preferences, `joined_at` AS joinedAt, `last_seen_at` AS lastSeenAt, `marked_all_as_read_at` AS markedAllAsReadAt, `read_notifications_at` AS readNotificationsAt, `discussion_count` AS discussionCount, `comment_count` AS commentCount, `read_flags_at` AS readFlagsAt, `suspended_until` AS suspendedUntil, `suspend_reason` AS suspendReason, `suspend_message` AS suspendMessage, `money` AS money, `best_answer_count` AS bestAnswerCount, `votes` AS votes, `rank` AS rank, `last_vote_time` AS lastVoteTime, `bio` AS bio, `cover` AS cover FROM `f_users`")
    List<UserPo> findAll();
    @Insert("INSERT INTO `f_users` (`id`, `username`, `nickname`, `email`, `is_email_confirmed`, `password`, `avatar_url`, `preferences`, `joined_at`, `last_seen_at`, `marked_all_as_read_at`, `read_notifications_at`, `discussion_count`, `comment_count`, `read_flags_at`, `suspended_until`, `suspend_reason`, `suspend_message`, `money`, `best_answer_count`, `votes`, `rank`, `last_vote_time`, `bio`, `cover`) VALUES (#{id}, #{username}, #{nickname}, #{email}, #{isEmailConfirmed}, #{password}, #{avatarUrl}, #{preferences}, #{joinedAt}, #{lastSeenAt}, #{markedAllAsReadAt}, #{readNotificationsAt}, #{discussionCount}, #{commentCount}, #{readFlagsAt}, #{suspendedUntil}, #{suspendReason}, #{suspendMessage}, #{money}, #{bestAnswerCount}, #{votes}, #{rank}, #{lastVoteTime}, #{bio}, #{cover})")
    int insert(UserPo po);
    @Update("UPDATE `f_users` SET `id` = #{id}, `username` = #{username}, `nickname` = #{nickname}, `email` = #{email}, `is_email_confirmed` = #{isEmailConfirmed}, `password` = #{password}, `avatar_url` = #{avatarUrl}, `preferences` = #{preferences}, `joined_at` = #{joinedAt}, `last_seen_at` = #{lastSeenAt}, `marked_all_as_read_at` = #{markedAllAsReadAt}, `read_notifications_at` = #{readNotificationsAt}, `discussion_count` = #{discussionCount}, `comment_count` = #{commentCount}, `read_flags_at` = #{readFlagsAt}, `suspended_until` = #{suspendedUntil}, `suspend_reason` = #{suspendReason}, `suspend_message` = #{suspendMessage}, `money` = #{money}, `best_answer_count` = #{bestAnswerCount}, `votes` = #{votes}, `rank` = #{rank}, `last_vote_time` = #{lastVoteTime}, `bio` = #{bio}, `cover` = #{cover} WHERE `id` = #{id}")
    int update(UserPo po);
    @Delete("DELETE FROM `f_users` WHERE `id` = #{id}")
    int deleteById(Long id);
}