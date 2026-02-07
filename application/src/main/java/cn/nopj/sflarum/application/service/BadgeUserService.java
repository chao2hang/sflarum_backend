package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.BadgeUser;
import cn.nopj.sflarum.domian.repository.BadgeUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class BadgeUserService {
    private final BadgeUserRepository repository;
    public BadgeUser findById(Long id) {
        return repository.findById(id);
    }
    public List<BadgeUser> listAll() {
        return repository.findAll();
    }
    public boolean create(BadgeUser entity) {
        return repository.create(entity);
    }
    public boolean update(BadgeUser entity) {
        return repository.update(entity);
    }
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}