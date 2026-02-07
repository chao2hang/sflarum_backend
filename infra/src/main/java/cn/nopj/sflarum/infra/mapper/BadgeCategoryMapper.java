package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.BadgeCategoryPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface BadgeCategoryMapper {
    @Select("SELECT `id` AS id, `name` AS name, `order` AS order, `description` AS description, `is_enabled` AS isEnabled, `created_at` AS createdAt, `is_table` AS isTable FROM `f_badge_category` WHERE `id` = #{id}")
    BadgeCategoryPo findById(Long id);
    @Select("SELECT `id` AS id, `name` AS name, `order` AS order, `description` AS description, `is_enabled` AS isEnabled, `created_at` AS createdAt, `is_table` AS isTable FROM `f_badge_category`")
    List<BadgeCategoryPo> findAll();
    @Insert("INSERT INTO `f_badge_category` (`id`, `name`, `order`, `description`, `is_enabled`, `created_at`, `is_table`) VALUES (#{id}, #{name}, #{order}, #{description}, #{isEnabled}, #{createdAt}, #{isTable})")
    int insert(BadgeCategoryPo po);
    @Update("UPDATE `f_badge_category` SET `id` = #{id}, `name` = #{name}, `order` = #{order}, `description` = #{description}, `is_enabled` = #{isEnabled}, `created_at` = #{createdAt}, `is_table` = #{isTable} WHERE `id` = #{id}")
    int update(BadgeCategoryPo po);
    @Delete("DELETE FROM `f_badge_category` WHERE `id` = #{id}")
    int deleteById(Long id);
}