package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.FlagPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface FlagMapper {
    @Select("SELECT `id` AS id, `post_id` AS postId, `type` AS type, `user_id` AS userId, `reason` AS reason, `reason_detail` AS reasonDetail, `created_at` AS createdAt FROM `f_flags` WHERE `id` = #{id}")
    FlagPo findById(Long id);
    @Select("SELECT `id` AS id, `post_id` AS postId, `type` AS type, `user_id` AS userId, `reason` AS reason, `reason_detail` AS reasonDetail, `created_at` AS createdAt FROM `f_flags`")
    List<FlagPo> findAll();
    @Insert("INSERT INTO `f_flags` (`id`, `post_id`, `type`, `user_id`, `reason`, `reason_detail`, `created_at`) VALUES (#{id}, #{postId}, #{type}, #{userId}, #{reason}, #{reasonDetail}, #{createdAt})")
    int insert(FlagPo po);
    @Update("UPDATE `f_flags` SET `id` = #{id}, `post_id` = #{postId}, `type` = #{type}, `user_id` = #{userId}, `reason` = #{reason}, `reason_detail` = #{reasonDetail}, `created_at` = #{createdAt} WHERE `id` = #{id}")
    int update(FlagPo po);
    @Delete("DELETE FROM `f_flags` WHERE `id` = #{id}")
    int deleteById(Long id);
}