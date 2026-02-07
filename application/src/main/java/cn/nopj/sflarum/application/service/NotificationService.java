package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.Notification;
import cn.nopj.sflarum.domian.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository repository;
    public Notification findById(Long id) {
        return repository.findById(id);
    }
    public List<Notification> listAll() {
        return repository.findAll();
    }
    public boolean create(Notification entity) {
        return repository.create(entity);
    }
    public boolean update(Notification entity) {
        return repository.update(entity);
    }
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}