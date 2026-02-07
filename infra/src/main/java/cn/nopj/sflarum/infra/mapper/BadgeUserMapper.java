package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.BadgeUserPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface BadgeUserMapper {
    @Select("SELECT `id` AS id, `user_id` AS userId, `badge_id` AS badgeId, `description` AS description, `is_primary` AS isPrimary, `assigned_at` AS assignedAt, `in_user_card` AS inUserCard FROM `f_badge_user` WHERE `id` = #{id}")
    BadgeUserPo findById(Long id);
    @Select("SELECT `id` AS id, `user_id` AS userId, `badge_id` AS badgeId, `description` AS description, `is_primary` AS isPrimary, `assigned_at` AS assignedAt, `in_user_card` AS inUserCard FROM `f_badge_user`")
    List<BadgeUserPo> findAll();
    @Insert("INSERT INTO `f_badge_user` (`id`, `user_id`, `badge_id`, `description`, `is_primary`, `assigned_at`, `in_user_card`) VALUES (#{id}, #{userId}, #{badgeId}, #{description}, #{isPrimary}, #{assignedAt}, #{inUserCard})")
    int insert(BadgeUserPo po);
    @Update("UPDATE `f_badge_user` SET `id` = #{id}, `user_id` = #{userId}, `badge_id` = #{badgeId}, `description` = #{description}, `is_primary` = #{isPrimary}, `assigned_at` = #{assignedAt}, `in_user_card` = #{inUserCard} WHERE `id` = #{id}")
    int update(BadgeUserPo po);
    @Delete("DELETE FROM `f_badge_user` WHERE `id` = #{id}")
    int deleteById(Long id);
}