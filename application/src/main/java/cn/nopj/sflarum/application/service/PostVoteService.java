package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.PostVote;
import cn.nopj.sflarum.domian.repository.PostVoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PostVoteService {
    private final PostVoteRepository repository;
    public PostVote findById(Long id) {
        return repository.findById(id);
    }
    public List<PostVote> listAll() {
        return repository.findAll();
    }
    public boolean create(PostVote entity) {
        return repository.create(entity);
    }
    public boolean update(PostVote entity) {
        return repository.update(entity);
    }
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}