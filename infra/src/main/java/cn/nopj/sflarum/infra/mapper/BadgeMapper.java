package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.BadgePo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface BadgeMapper {
    @Select("SELECT `id` AS id, `name` AS name, `icon` AS icon, `order` AS order, `image` AS image, `description` AS description, `is_visible` AS isVisible, `created_at` AS createdAt, `badge_category_id` AS badgeCategoryId, `points` AS points, `background_color` AS backgroundColor, `icon_color` AS iconColor, `label_color` AS labelColor FROM `f_badges` WHERE `id` = #{id}")
    BadgePo findById(Long id);
    @Select("SELECT `id` AS id, `name` AS name, `icon` AS icon, `order` AS order, `image` AS image, `description` AS description, `is_visible` AS isVisible, `created_at` AS createdAt, `badge_category_id` AS badgeCategoryId, `points` AS points, `background_color` AS backgroundColor, `icon_color` AS iconColor, `label_color` AS labelColor FROM `f_badges`")
    List<BadgePo> findAll();
    @Insert("INSERT INTO `f_badges` (`id`, `name`, `icon`, `order`, `image`, `description`, `is_visible`, `created_at`, `badge_category_id`, `points`, `background_color`, `icon_color`, `label_color`) VALUES (#{id}, #{name}, #{icon}, #{order}, #{image}, #{description}, #{isVisible}, #{createdAt}, #{badgeCategoryId}, #{points}, #{backgroundColor}, #{iconColor}, #{labelColor})")
    int insert(BadgePo po);
    @Update("UPDATE `f_badges` SET `id` = #{id}, `name` = #{name}, `icon` = #{icon}, `order` = #{order}, `image` = #{image}, `description` = #{description}, `is_visible` = #{isVisible}, `created_at` = #{createdAt}, `badge_category_id` = #{badgeCategoryId}, `points` = #{points}, `background_color` = #{backgroundColor}, `icon_color` = #{iconColor}, `label_color` = #{labelColor} WHERE `id` = #{id}")
    int update(BadgePo po);
    @Delete("DELETE FROM `f_badges` WHERE `id` = #{id}")
    int deleteById(Long id);
}