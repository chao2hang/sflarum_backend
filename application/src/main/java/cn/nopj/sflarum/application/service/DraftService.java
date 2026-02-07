package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.Draft;
import cn.nopj.sflarum.domian.repository.DraftRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DraftService {
    private final DraftRepository repository;
    public Draft findById(Long id) {
        return repository.findById(id);
    }
    public List<Draft> listAll() {
        return repository.findAll();
    }
    public boolean create(Draft entity) {
        return repository.create(entity);
    }
    public boolean update(Draft entity) {
        return repository.update(entity);
    }
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}