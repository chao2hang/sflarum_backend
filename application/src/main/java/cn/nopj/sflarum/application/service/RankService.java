package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.Rank;
import cn.nopj.sflarum.domian.repository.RankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class RankService {
    private final RankRepository repository;
    public Rank findById(Long id) {
        return repository.findById(id);
    }
    public List<Rank> listAll() {
        return repository.findAll();
    }
    public boolean create(Rank entity) {
        return repository.create(entity);
    }
    public boolean update(Rank entity) {
        return repository.update(entity);
    }
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}