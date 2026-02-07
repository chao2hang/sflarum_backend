package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.PasswordToken;
import java.util.List;
public interface PasswordTokenRepository {
    PasswordToken findById(String id);
    List<PasswordToken> findAll();
    boolean create(PasswordToken entity);
    boolean update(PasswordToken entity);
    boolean delete(String id);
}