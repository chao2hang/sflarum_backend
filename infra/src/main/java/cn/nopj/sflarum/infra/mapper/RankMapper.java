package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.RankPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface RankMapper {
    @Select("SELECT `id` AS id, `points` AS points, `name` AS name, `color` AS color FROM `f_ranks` WHERE `id` = #{id}")
    RankPo findById(Long id);
    @Select("SELECT `id` AS id, `points` AS points, `name` AS name, `color` AS color FROM `f_ranks`")
    List<RankPo> findAll();
    @Insert("INSERT INTO `f_ranks` (`id`, `points`, `name`, `color`) VALUES (#{id}, #{points}, #{name}, #{color})")
    int insert(RankPo po);
    @Update("UPDATE `f_ranks` SET `id` = #{id}, `points` = #{points}, `name` = #{name}, `color` = #{color} WHERE `id` = #{id}")
    int update(RankPo po);
    @Delete("DELETE FROM `f_ranks` WHERE `id` = #{id}")
    int deleteById(Long id);
}