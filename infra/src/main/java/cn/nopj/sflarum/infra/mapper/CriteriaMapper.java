package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.CriteriaPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface CriteriaMapper {
    @Select("SELECT `id` AS id, `last_edited_by_id` AS lastEditedById, `name` AS name, `icon` AS icon, `description` AS description, `metrics` AS metrics, `requirements` AS requirements, `actions` AS actions FROM `f_criteria` WHERE `id` = #{id}")
    CriteriaPo findById(Long id);
    @Select("SELECT `id` AS id, `last_edited_by_id` AS lastEditedById, `name` AS name, `icon` AS icon, `description` AS description, `metrics` AS metrics, `requirements` AS requirements, `actions` AS actions FROM `f_criteria`")
    List<CriteriaPo> findAll();
    @Insert("INSERT INTO `f_criteria` (`id`, `last_edited_by_id`, `name`, `icon`, `description`, `metrics`, `requirements`, `actions`) VALUES (#{id}, #{lastEditedById}, #{name}, #{icon}, #{description}, #{metrics}, #{requirements}, #{actions})")
    int insert(CriteriaPo po);
    @Update("UPDATE `f_criteria` SET `id` = #{id}, `last_edited_by_id` = #{lastEditedById}, `name` = #{name}, `icon` = #{icon}, `description` = #{description}, `metrics` = #{metrics}, `requirements` = #{requirements}, `actions` = #{actions} WHERE `id` = #{id}")
    int update(CriteriaPo po);
    @Delete("DELETE FROM `f_criteria` WHERE `id` = #{id}")
    int deleteById(Long id);
}