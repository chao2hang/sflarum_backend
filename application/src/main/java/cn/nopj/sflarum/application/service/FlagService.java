package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.Flag;
import cn.nopj.sflarum.domian.repository.FlagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class FlagService {
    private final FlagRepository repository;
    public Flag findById(Long id) {
        return repository.findById(id);
    }
    public List<Flag> listAll() {
        return repository.findAll();
    }
    public boolean create(Flag entity) {
        return repository.create(entity);
    }
    public boolean update(Flag entity) {
        return repository.update(entity);
    }
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}