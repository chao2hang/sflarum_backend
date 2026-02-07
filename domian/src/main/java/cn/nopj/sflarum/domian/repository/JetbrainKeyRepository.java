package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.JetbrainKey;
import java.util.List;
public interface JetbrainKeyRepository {
    JetbrainKey findById(Integer id);
    List<JetbrainKey> findAll();
    boolean create(JetbrainKey entity);
    boolean update(JetbrainKey entity);
    boolean delete(Integer id);
}