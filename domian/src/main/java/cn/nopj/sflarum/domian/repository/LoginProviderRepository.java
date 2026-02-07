package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.LoginProvider;
import java.util.List;
public interface LoginProviderRepository {
    LoginProvider findById(Long id);
    List<LoginProvider> findAll();
    boolean create(LoginProvider entity);
    boolean update(LoginProvider entity);
    boolean delete(Long id);
}