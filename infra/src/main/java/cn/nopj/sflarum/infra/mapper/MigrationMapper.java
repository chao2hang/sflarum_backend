package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.MigrationPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface MigrationMapper {
    @Select("SELECT `id` AS id, `migration` AS migration, `extension` AS extension FROM `f_migrations` WHERE `id` = #{id}")
    MigrationPo findById(Long id);
    @Select("SELECT `id` AS id, `migration` AS migration, `extension` AS extension FROM `f_migrations`")
    List<MigrationPo> findAll();
    @Insert("INSERT INTO `f_migrations` (`id`, `migration`, `extension`) VALUES (#{id}, #{migration}, #{extension})")
    int insert(MigrationPo po);
    @Update("UPDATE `f_migrations` SET `id` = #{id}, `migration` = #{migration}, `extension` = #{extension} WHERE `id` = #{id}")
    int update(MigrationPo po);
    @Delete("DELETE FROM `f_migrations` WHERE `id` = #{id}")
    int deleteById(Long id);
}