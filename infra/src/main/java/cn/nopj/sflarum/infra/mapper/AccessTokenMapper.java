package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.AccessTokenPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface AccessTokenMapper {
    @Select("SELECT `id` AS id, `token` AS token, `user_id` AS userId, `last_activity_at` AS lastActivityAt, `created_at` AS createdAt, `type` AS type, `title` AS title, `last_ip_address` AS lastIpAddress, `last_user_agent` AS lastUserAgent FROM `f_access_tokens` WHERE `id` = #{id}")
    AccessTokenPo findById(Long id);
    @Select("SELECT `id` AS id, `token` AS token, `user_id` AS userId, `last_activity_at` AS lastActivityAt, `created_at` AS createdAt, `type` AS type, `title` AS title, `last_ip_address` AS lastIpAddress, `last_user_agent` AS lastUserAgent FROM `f_access_tokens`")
    List<AccessTokenPo> findAll();
    @Insert("INSERT INTO `f_access_tokens` (`id`, `token`, `user_id`, `last_activity_at`, `created_at`, `type`, `title`, `last_ip_address`, `last_user_agent`) VALUES (#{id}, #{token}, #{userId}, #{lastActivityAt}, #{createdAt}, #{type}, #{title}, #{lastIpAddress}, #{lastUserAgent})")
    int insert(AccessTokenPo po);
    @Update("UPDATE `f_access_tokens` SET `id` = #{id}, `token` = #{token}, `user_id` = #{userId}, `last_activity_at` = #{lastActivityAt}, `created_at` = #{createdAt}, `type` = #{type}, `title` = #{title}, `last_ip_address` = #{lastIpAddress}, `last_user_agent` = #{lastUserAgent} WHERE `id` = #{id}")
    int update(AccessTokenPo po);
    @Delete("DELETE FROM `f_access_tokens` WHERE `id` = #{id}")
    int deleteById(Long id);
}