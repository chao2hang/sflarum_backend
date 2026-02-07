package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.Poll;
import cn.nopj.sflarum.domian.repository.PollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PollService {
    private final PollRepository repository;
    public Poll findById(Long id) {
        return repository.findById(id);
    }
    public List<Poll> listAll() {
        return repository.findAll();
    }
    public boolean create(Poll entity) {
        return repository.create(entity);
    }
    public boolean update(Poll entity) {
        return repository.update(entity);
    }
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}