package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.Badge;
import cn.nopj.sflarum.domian.repository.BadgeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class BadgeService {
    private final BadgeRepository repository;
    public Badge findById(Long id) {
        return repository.findById(id);
    }
    public List<Badge> listAll() {
        return repository.findAll();
    }
    public boolean create(Badge entity) {
        return repository.create(entity);
    }
    public boolean update(Badge entity) {
        return repository.update(entity);
    }
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}