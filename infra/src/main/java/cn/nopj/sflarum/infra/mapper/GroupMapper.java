package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.GroupPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface GroupMapper {
    @Select("SELECT `id` AS id, `name_singular` AS nameSingular, `name_plural` AS namePlural, `color` AS color, `icon` AS icon, `is_hidden` AS isHidden, `created_at` AS createdAt, `updated_at` AS updatedAt FROM `f_groups` WHERE `id` = #{id}")
    GroupPo findById(Long id);
    @Select("SELECT `id` AS id, `name_singular` AS nameSingular, `name_plural` AS namePlural, `color` AS color, `icon` AS icon, `is_hidden` AS isHidden, `created_at` AS createdAt, `updated_at` AS updatedAt FROM `f_groups`")
    List<GroupPo> findAll();
    @Insert("INSERT INTO `f_groups` (`id`, `name_singular`, `name_plural`, `color`, `icon`, `is_hidden`, `created_at`, `updated_at`) VALUES (#{id}, #{nameSingular}, #{namePlural}, #{color}, #{icon}, #{isHidden}, #{createdAt}, #{updatedAt})")
    int insert(GroupPo po);
    @Update("UPDATE `f_groups` SET `id` = #{id}, `name_singular` = #{nameSingular}, `name_plural` = #{namePlural}, `color` = #{color}, `icon` = #{icon}, `is_hidden` = #{isHidden}, `created_at` = #{createdAt}, `updated_at` = #{updatedAt} WHERE `id` = #{id}")
    int update(GroupPo po);
    @Delete("DELETE FROM `f_groups` WHERE `id` = #{id}")
    int deleteById(Long id);
}