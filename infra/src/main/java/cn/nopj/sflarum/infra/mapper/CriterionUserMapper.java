package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.CriterionUserPo;
import cn.nopj.sflarum.domian.entity.key.CriterionUserKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface CriterionUserMapper {
    @Select("SELECT `criterion_id` AS criterionId, `user_id` AS userId FROM `f_criterion_user` WHERE `criterion_id` = #{criterionId} AND `user_id` = #{userId}")
    CriterionUserPo findById(CriterionUserKey key);
    @Select("SELECT `criterion_id` AS criterionId, `user_id` AS userId FROM `f_criterion_user`")
    List<CriterionUserPo> findAll();
    @Insert("INSERT INTO `f_criterion_user` (`criterion_id`, `user_id`) VALUES (#{criterionId}, #{userId})")
    int insert(CriterionUserPo po);
    @Update("UPDATE `f_criterion_user` SET `criterion_id` = #{criterionId}, `user_id` = #{userId} WHERE `criterion_id` = #{criterionId} AND `user_id` = #{userId}")
    int update(CriterionUserPo po);
    @Delete("DELETE FROM `f_criterion_user` WHERE `criterion_id` = #{criterionId} AND `user_id` = #{userId}")
    int deleteById(CriterionUserKey key);
}