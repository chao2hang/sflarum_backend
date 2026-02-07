package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.Badge;
import java.util.List;
public interface BadgeRepository {
    Badge findById(Long id);
    List<Badge> findAll();
    boolean create(Badge entity);
    boolean update(Badge entity);
    boolean delete(Long id);
}