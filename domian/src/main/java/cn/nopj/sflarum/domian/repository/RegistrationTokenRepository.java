package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.RegistrationToken;
import java.util.List;
public interface RegistrationTokenRepository {
    RegistrationToken findById(String id);
    List<RegistrationToken> findAll();
    boolean create(RegistrationToken entity);
    boolean update(RegistrationToken entity);
    boolean delete(String id);
}