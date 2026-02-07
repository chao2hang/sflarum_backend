package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.AccessToken;
import java.util.List;
public interface AccessTokenRepository {
    AccessToken findById(Long id);
    AccessToken findByToken(String token);
    List<AccessToken> findAll();
    boolean create(AccessToken entity);
    boolean update(AccessToken entity);
    boolean updateLastActivity(String token, java.time.LocalDateTime lastActivityAt, String lastIpAddress, String lastUserAgent);
    boolean delete(Long id);
}
