package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.PollVotePo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface PollVoteMapper {
    @Select("SELECT `id` AS id, `poll_id` AS pollId, `option_id` AS optionId, `user_id` AS userId, `created_at` AS createdAt, `updated_at` AS updatedAt FROM `f_poll_votes` WHERE `id` = #{id}")
    PollVotePo findById(Long id);
    @Select("SELECT `id` AS id, `poll_id` AS pollId, `option_id` AS optionId, `user_id` AS userId, `created_at` AS createdAt, `updated_at` AS updatedAt FROM `f_poll_votes`")
    List<PollVotePo> findAll();
    @Insert("INSERT INTO `f_poll_votes` (`id`, `poll_id`, `option_id`, `user_id`, `created_at`, `updated_at`) VALUES (#{id}, #{pollId}, #{optionId}, #{userId}, #{createdAt}, #{updatedAt})")
    int insert(PollVotePo po);
    @Update("UPDATE `f_poll_votes` SET `id` = #{id}, `poll_id` = #{pollId}, `option_id` = #{optionId}, `user_id` = #{userId}, `created_at` = #{createdAt}, `updated_at` = #{updatedAt} WHERE `id` = #{id}")
    int update(PollVotePo po);
    @Delete("DELETE FROM `f_poll_votes` WHERE `id` = #{id}")
    int deleteById(Long id);
}