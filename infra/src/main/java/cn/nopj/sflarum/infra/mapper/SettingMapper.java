package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.SettingPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface SettingMapper {
    @Select("SELECT `key` AS key, `value` AS value FROM `f_settings` WHERE `key` = #{id}")
    SettingPo findById(String id);
    @Select("SELECT `key` AS key, `value` AS value FROM `f_settings`")
    List<SettingPo> findAll();
    @Insert("INSERT INTO `f_settings` (`key`, `value`) VALUES (#{key}, #{value})")
    int insert(SettingPo po);
    @Update("UPDATE `f_settings` SET `key` = #{key}, `value` = #{value} WHERE `key` = #{id}")
    int update(SettingPo po);
    @Delete("DELETE FROM `f_settings` WHERE `key` = #{id}")
    int deleteById(String id);
}