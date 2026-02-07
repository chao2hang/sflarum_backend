package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.PasswordTokenPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface PasswordTokenMapper {
    @Select("SELECT `token` AS token, `user_id` AS userId, `created_at` AS createdAt FROM `f_password_tokens` WHERE `token` = #{id}")
    PasswordTokenPo findById(String id);
    @Select("SELECT `token` AS token, `user_id` AS userId, `created_at` AS createdAt FROM `f_password_tokens`")
    List<PasswordTokenPo> findAll();
    @Insert("INSERT INTO `f_password_tokens` (`token`, `user_id`, `created_at`) VALUES (#{token}, #{userId}, #{createdAt})")
    int insert(PasswordTokenPo po);
    @Update("UPDATE `f_password_tokens` SET `token` = #{token}, `user_id` = #{userId}, `created_at` = #{createdAt} WHERE `token` = #{id}")
    int update(PasswordTokenPo po);
    @Delete("DELETE FROM `f_password_tokens` WHERE `token` = #{id}")
    int deleteById(String id);
}