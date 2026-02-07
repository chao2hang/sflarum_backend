package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.BadgeUser;
import java.util.List;
public interface BadgeUserRepository {
    BadgeUser findById(Long id);
    List<BadgeUser> findAll();
    boolean create(BadgeUser entity);
    boolean update(BadgeUser entity);
    boolean delete(Long id);
}