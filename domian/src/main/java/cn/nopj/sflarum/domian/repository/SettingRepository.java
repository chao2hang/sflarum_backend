package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.Setting;
import java.util.List;
public interface SettingRepository {
    Setting findById(String id);
    List<Setting> findAll();
    boolean create(Setting entity);
    boolean update(Setting entity);
    boolean delete(String id);
}