package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.Criteria;
import cn.nopj.sflarum.domian.repository.CriteriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CriteriaService {
    private final CriteriaRepository repository;
    public Criteria findById(Long id) {
        return repository.findById(id);
    }
    public List<Criteria> listAll() {
        return repository.findAll();
    }
    public boolean create(Criteria entity) {
        return repository.create(entity);
    }
    public boolean update(Criteria entity) {
        return repository.update(entity);
    }
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}