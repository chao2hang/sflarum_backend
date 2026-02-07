package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.NotificationPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface NotificationMapper {
    @Select("SELECT `id` AS id, `user_id` AS userId, `from_user_id` AS fromUserId, `type` AS type, `subject_id` AS subjectId, `data` AS data, `created_at` AS createdAt, `is_deleted` AS isDeleted, `read_at` AS readAt FROM `f_notifications` WHERE `id` = #{id}")
    NotificationPo findById(Long id);
    @Select("SELECT `id` AS id, `user_id` AS userId, `from_user_id` AS fromUserId, `type` AS type, `subject_id` AS subjectId, `data` AS data, `created_at` AS createdAt, `is_deleted` AS isDeleted, `read_at` AS readAt FROM `f_notifications`")
    List<NotificationPo> findAll();
    @Insert("INSERT INTO `f_notifications` (`id`, `user_id`, `from_user_id`, `type`, `subject_id`, `data`, `created_at`, `is_deleted`, `read_at`) VALUES (#{id}, #{userId}, #{fromUserId}, #{type}, #{subjectId}, #{data}, #{createdAt}, #{isDeleted}, #{readAt})")
    int insert(NotificationPo po);
    @Update("UPDATE `f_notifications` SET `id` = #{id}, `user_id` = #{userId}, `from_user_id` = #{fromUserId}, `type` = #{type}, `subject_id` = #{subjectId}, `data` = #{data}, `created_at` = #{createdAt}, `is_deleted` = #{isDeleted}, `read_at` = #{readAt} WHERE `id` = #{id}")
    int update(NotificationPo po);
    @Delete("DELETE FROM `f_notifications` WHERE `id` = #{id}")
    int deleteById(Long id);
}