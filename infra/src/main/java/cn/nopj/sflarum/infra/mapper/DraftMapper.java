package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.DraftPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface DraftMapper {
    @Select("SELECT `id` AS id, `user_id` AS userId, `title` AS title, `content` AS content, `relationships` AS relationships, `updated_at` AS updatedAt, `scheduled_for` AS scheduledFor, `scheduled_validation_error` AS scheduledValidationError, `ip_address` AS ipAddress, `extra` AS extra FROM `f_drafts` WHERE `id` = #{id}")
    DraftPo findById(Long id);
    @Select("SELECT `id` AS id, `user_id` AS userId, `title` AS title, `content` AS content, `relationships` AS relationships, `updated_at` AS updatedAt, `scheduled_for` AS scheduledFor, `scheduled_validation_error` AS scheduledValidationError, `ip_address` AS ipAddress, `extra` AS extra FROM `f_drafts`")
    List<DraftPo> findAll();
    @Insert("INSERT INTO `f_drafts` (`id`, `user_id`, `title`, `content`, `relationships`, `updated_at`, `scheduled_for`, `scheduled_validation_error`, `ip_address`, `extra`) VALUES (#{id}, #{userId}, #{title}, #{content}, #{relationships}, #{updatedAt}, #{scheduledFor}, #{scheduledValidationError}, #{ipAddress}, #{extra})")
    int insert(DraftPo po);
    @Update("UPDATE `f_drafts` SET `id` = #{id}, `user_id` = #{userId}, `title` = #{title}, `content` = #{content}, `relationships` = #{relationships}, `updated_at` = #{updatedAt}, `scheduled_for` = #{scheduledFor}, `scheduled_validation_error` = #{scheduledValidationError}, `ip_address` = #{ipAddress}, `extra` = #{extra} WHERE `id` = #{id}")
    int update(DraftPo po);
    @Delete("DELETE FROM `f_drafts` WHERE `id` = #{id}")
    int deleteById(Long id);
}