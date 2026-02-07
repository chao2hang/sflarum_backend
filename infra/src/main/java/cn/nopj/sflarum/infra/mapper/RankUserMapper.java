package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.RankUserPo;
import cn.nopj.sflarum.domian.entity.key.RankUserKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface RankUserMapper {
    @Select("SELECT `rank_id` AS rankId, `user_id` AS userId FROM `f_rank_users` WHERE `user_id` = #{userId} AND `rank_id` = #{rankId}")
    RankUserPo findById(RankUserKey key);
    @Select("SELECT `rank_id` AS rankId, `user_id` AS userId FROM `f_rank_users`")
    List<RankUserPo> findAll();
    @Insert("INSERT INTO `f_rank_users` (`rank_id`, `user_id`) VALUES (#{rankId}, #{userId})")
    int insert(RankUserPo po);
    @Update("UPDATE `f_rank_users` SET `rank_id` = #{rankId}, `user_id` = #{userId} WHERE `user_id` = #{userId} AND `rank_id` = #{rankId}")
    int update(RankUserPo po);
    @Delete("DELETE FROM `f_rank_users` WHERE `user_id` = #{userId} AND `rank_id` = #{rankId}")
    int deleteById(RankUserKey key);
}