package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.Migration;
import cn.nopj.sflarum.domian.repository.MigrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class MigrationService {
    private final MigrationRepository repository;
    public Migration findById(Long id) {
        return repository.findById(id);
    }
    public List<Migration> listAll() {
        return repository.findAll();
    }
    public boolean create(Migration entity) {
        return repository.create(entity);
    }
    public boolean update(Migration entity) {
        return repository.update(entity);
    }
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}