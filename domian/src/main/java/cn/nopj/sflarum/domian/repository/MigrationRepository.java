package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.Migration;
import java.util.List;
public interface MigrationRepository {
    Migration findById(Long id);
    List<Migration> findAll();
    boolean create(Migration entity);
    boolean update(Migration entity);
    boolean delete(Long id);
}