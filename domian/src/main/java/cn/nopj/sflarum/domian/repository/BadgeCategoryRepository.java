package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.BadgeCategory;
import java.util.List;
public interface BadgeCategoryRepository {
    BadgeCategory findById(Long id);
    List<BadgeCategory> findAll();
    boolean create(BadgeCategory entity);
    boolean update(BadgeCategory entity);
    boolean delete(Long id);
}