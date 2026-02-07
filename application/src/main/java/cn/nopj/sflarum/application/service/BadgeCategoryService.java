package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.BadgeCategory;
import cn.nopj.sflarum.domian.repository.BadgeCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class BadgeCategoryService {
    private final BadgeCategoryRepository repository;
    public BadgeCategory findById(Long id) {
        return repository.findById(id);
    }
    public List<BadgeCategory> listAll() {
        return repository.findAll();
    }
    public boolean create(BadgeCategory entity) {
        return repository.create(entity);
    }
    public boolean update(BadgeCategory entity) {
        return repository.update(entity);
    }
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}