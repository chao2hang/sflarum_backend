package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.EmailTokenPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface EmailTokenMapper {
    @Select("SELECT `token` AS token, `email` AS email, `user_id` AS userId, `created_at` AS createdAt FROM `f_email_tokens` WHERE `token` = #{id}")
    EmailTokenPo findById(String id);
    @Select("SELECT `token` AS token, `email` AS email, `user_id` AS userId, `created_at` AS createdAt FROM `f_email_tokens`")
    List<EmailTokenPo> findAll();
    @Insert("INSERT INTO `f_email_tokens` (`token`, `email`, `user_id`, `created_at`) VALUES (#{token}, #{email}, #{userId}, #{createdAt})")
    int insert(EmailTokenPo po);
    @Update("UPDATE `f_email_tokens` SET `token` = #{token}, `email` = #{email}, `user_id` = #{userId}, `created_at` = #{createdAt} WHERE `token` = #{id}")
    int update(EmailTokenPo po);
    @Delete("DELETE FROM `f_email_tokens` WHERE `token` = #{id}")
    int deleteById(String id);
}