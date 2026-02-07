package cn.nopj.sflarum.infra.mapper;
import cn.nopj.sflarum.infra.po.RegistrationTokenPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
@Mapper
public interface RegistrationTokenMapper {
    @Select("SELECT `token` AS token, `payload` AS payload, `created_at` AS createdAt, `provider` AS provider, `identifier` AS identifier, `user_attributes` AS userAttributes FROM `f_registration_tokens` WHERE `token` = #{id}")
    RegistrationTokenPo findById(String id);
    @Select("SELECT `token` AS token, `payload` AS payload, `created_at` AS createdAt, `provider` AS provider, `identifier` AS identifier, `user_attributes` AS userAttributes FROM `f_registration_tokens`")
    List<RegistrationTokenPo> findAll();
    @Insert("INSERT INTO `f_registration_tokens` (`token`, `payload`, `created_at`, `provider`, `identifier`, `user_attributes`) VALUES (#{token}, #{payload}, #{createdAt}, #{provider}, #{identifier}, #{userAttributes})")
    int insert(RegistrationTokenPo po);
    @Update("UPDATE `f_registration_tokens` SET `token` = #{token}, `payload` = #{payload}, `created_at` = #{createdAt}, `provider` = #{provider}, `identifier` = #{identifier}, `user_attributes` = #{userAttributes} WHERE `token` = #{id}")
    int update(RegistrationTokenPo po);
    @Delete("DELETE FROM `f_registration_tokens` WHERE `token` = #{id}")
    int deleteById(String id);
}