package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.JetbrainKeyPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface JetbrainKeyMapper {
    @Select("SELECT `id` AS id, `name` AS name, `keyword` AS keyword, `software_key` AS softwareKey, `created_at` AS createdAt, `updated_at` AS updatedAt FROM `f_jetbrains_keys` WHERE `id` = #{id}")
    JetbrainKeyPo findById(Integer id);
    @Select("SELECT `id` AS id, `name` AS name, `keyword` AS keyword, `software_key` AS softwareKey, `created_at` AS createdAt, `updated_at` AS updatedAt FROM `f_jetbrains_keys`")
    List<JetbrainKeyPo> findAll();
    @Insert("INSERT INTO `f_jetbrains_keys` (`id`, `name`, `keyword`, `software_key`, `created_at`, `updated_at`) VALUES (#{id}, #{name}, #{keyword}, #{softwareKey}, #{createdAt}, #{updatedAt})")
    int insert(JetbrainKeyPo po);
    @Update("UPDATE `f_jetbrains_keys` SET `id` = #{id}, `name` = #{name}, `keyword` = #{keyword}, `software_key` = #{softwareKey}, `created_at` = #{createdAt}, `updated_at` = #{updatedAt} WHERE `id` = #{id}")
    int update(JetbrainKeyPo po);
    @Delete("DELETE FROM `f_jetbrains_keys` WHERE `id` = #{id}")
    int deleteById(Integer id);
}