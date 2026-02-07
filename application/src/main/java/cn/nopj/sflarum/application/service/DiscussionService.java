package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.Discussion;
import cn.nopj.sflarum.domian.repository.DiscussionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DiscussionService {
    private final DiscussionRepository repository;
    public Discussion findById(Long id) {
        return repository.findById(id);
    }
    public List<Discussion> listAll() {
        return repository.findAll();
    }
    public boolean create(Discussion entity) {
        return repository.create(entity);
    }
    public boolean update(Discussion entity) {
        return repository.update(entity);
    }
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}