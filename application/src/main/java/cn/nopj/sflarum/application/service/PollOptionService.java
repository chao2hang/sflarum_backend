package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.PollOption;
import cn.nopj.sflarum.domian.repository.PollOptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PollOptionService {
    private final PollOptionRepository repository;
    public PollOption findById(Long id) {
        return repository.findById(id);
    }
    public List<PollOption> listAll() {
        return repository.findAll();
    }
    public boolean create(PollOption entity) {
        return repository.create(entity);
    }
    public boolean update(PollOption entity) {
        return repository.update(entity);
    }
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}