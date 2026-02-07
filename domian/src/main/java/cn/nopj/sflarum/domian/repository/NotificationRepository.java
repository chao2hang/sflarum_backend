package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.Notification;
import java.util.List;
public interface NotificationRepository {
    Notification findById(Long id);
    List<Notification> findAll();
    boolean create(Notification entity);
    boolean update(Notification entity);
    boolean delete(Long id);
}