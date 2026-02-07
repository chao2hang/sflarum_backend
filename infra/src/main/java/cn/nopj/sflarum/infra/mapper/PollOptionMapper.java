package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.PollOptionPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface PollOptionMapper {
    @Select("SELECT `id` AS id, `answer` AS answer, `poll_id` AS pollId, `created_at` AS createdAt, `updated_at` AS updatedAt, `vote_count` AS voteCount, `image_url` AS imageUrl FROM `f_poll_options` WHERE `id` = #{id}")
    PollOptionPo findById(Long id);
    @Select("SELECT `id` AS id, `answer` AS answer, `poll_id` AS pollId, `created_at` AS createdAt, `updated_at` AS updatedAt, `vote_count` AS voteCount, `image_url` AS imageUrl FROM `f_poll_options`")
    List<PollOptionPo> findAll();
    @Insert("INSERT INTO `f_poll_options` (`id`, `answer`, `poll_id`, `created_at`, `updated_at`, `vote_count`, `image_url`) VALUES (#{id}, #{answer}, #{pollId}, #{createdAt}, #{updatedAt}, #{voteCount}, #{imageUrl})")
    int insert(PollOptionPo po);
    @Update("UPDATE `f_poll_options` SET `id` = #{id}, `answer` = #{answer}, `poll_id` = #{pollId}, `created_at` = #{createdAt}, `updated_at` = #{updatedAt}, `vote_count` = #{voteCount}, `image_url` = #{imageUrl} WHERE `id` = #{id}")
    int update(PollOptionPo po);
    @Delete("DELETE FROM `f_poll_options` WHERE `id` = #{id}")
    int deleteById(Long id);
}