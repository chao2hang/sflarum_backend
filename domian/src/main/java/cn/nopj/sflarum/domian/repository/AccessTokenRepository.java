package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.AccessToken;
import java.util.List;
public interface AccessTokenRepository {
    AccessToken findById(Long id);
    List<AccessToken> findAll();
    boolean create(AccessToken entity);
    boolean update(AccessToken entity);
    boolean delete(Long id);
}