package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.LoginProviderPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface LoginProviderMapper {
    @Select("SELECT `id` AS id, `user_id` AS userId, `provider` AS provider, `identifier` AS identifier, `created_at` AS createdAt, `last_login_at` AS lastLoginAt FROM `f_login_providers` WHERE `id` = #{id}")
    LoginProviderPo findById(Long id);
    @Select("SELECT `id` AS id, `user_id` AS userId, `provider` AS provider, `identifier` AS identifier, `created_at` AS createdAt, `last_login_at` AS lastLoginAt FROM `f_login_providers`")
    List<LoginProviderPo> findAll();
    @Insert("INSERT INTO `f_login_providers` (`id`, `user_id`, `provider`, `identifier`, `created_at`, `last_login_at`) VALUES (#{id}, #{userId}, #{provider}, #{identifier}, #{createdAt}, #{lastLoginAt})")
    int insert(LoginProviderPo po);
    @Update("UPDATE `f_login_providers` SET `id` = #{id}, `user_id` = #{userId}, `provider` = #{provider}, `identifier` = #{identifier}, `created_at` = #{createdAt}, `last_login_at` = #{lastLoginAt} WHERE `id` = #{id}")
    int update(LoginProviderPo po);
    @Delete("DELETE FROM `f_login_providers` WHERE `id` = #{id}")
    int deleteById(Long id);
}