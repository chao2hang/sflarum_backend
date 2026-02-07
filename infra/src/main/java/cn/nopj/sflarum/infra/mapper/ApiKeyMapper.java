package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.ApiKeyPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface ApiKeyMapper extends BaseMapper<ApiKeyPo> {
    @Select("SELECT `key` AS key, `id` AS id, `allowed_ips` AS allowedIps, `scopes` AS scopes, `user_id` AS userId, `created_at` AS createdAt, `last_activity_at` AS lastActivityAt FROM `f_api_keys` WHERE `id` = #{id}")
    ApiKeyPo findById(Long id);
    @Select("SELECT `key` AS key, `id` AS id, `allowed_ips` AS allowedIps, `scopes` AS scopes, `user_id` AS userId, `created_at` AS createdAt, `last_activity_at` AS lastActivityAt FROM `f_api_keys` WHERE `key` = #{key}")
    ApiKeyPo findByKey(String key);
    @Select("SELECT `key` AS key, `id` AS id, `allowed_ips` AS allowedIps, `scopes` AS scopes, `user_id` AS userId, `created_at` AS createdAt, `last_activity_at` AS lastActivityAt FROM `f_api_keys`")
    List<ApiKeyPo> findAll();
    @Insert("INSERT INTO `f_api_keys` (`key`, `id`, `allowed_ips`, `scopes`, `user_id`, `created_at`, `last_activity_at`) VALUES (#{key}, #{id}, #{allowedIps}, #{scopes}, #{userId}, #{createdAt}, #{lastActivityAt})")
    int insert(ApiKeyPo po);
    @Update("UPDATE `f_api_keys` SET `key` = #{key}, `id` = #{id}, `allowed_ips` = #{allowedIps}, `scopes` = #{scopes}, `user_id` = #{userId}, `created_at` = #{createdAt}, `last_activity_at` = #{lastActivityAt} WHERE `id` = #{id}")
    int update(ApiKeyPo po);
    @Update("UPDATE `f_api_keys` SET `last_activity_at` = #{lastActivityAt} WHERE `key` = #{key}")
    int updateLastActivity(String key, java.time.LocalDateTime lastActivityAt);
    @Delete("DELETE FROM `f_api_keys` WHERE `id` = #{id}")
    int deleteById(Long id);
}
