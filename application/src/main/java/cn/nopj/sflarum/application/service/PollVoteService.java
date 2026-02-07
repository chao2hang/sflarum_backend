package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.PollVote;
import cn.nopj.sflarum.domian.repository.PollVoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PollVoteService {
    private final PollVoteRepository repository;
    public PollVote findById(Long id) {
        return repository.findById(id);
    }
    public List<PollVote> listAll() {
        return repository.findAll();
    }
    public boolean create(PollVote entity) {
        return repository.create(entity);
    }
    public boolean update(PollVote entity) {
        return repository.update(entity);
    }
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}