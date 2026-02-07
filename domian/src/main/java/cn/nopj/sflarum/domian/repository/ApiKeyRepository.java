package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.ApiKey;
import java.util.List;
public interface ApiKeyRepository {
    ApiKey findById(Long id);
    ApiKey findByKey(String key);
    List<ApiKey> findAll();
    boolean create(ApiKey entity);
    boolean update(ApiKey entity);
    boolean updateLastActivity(String key, java.time.LocalDateTime lastActivityAt);
    boolean delete(Long id);
}
