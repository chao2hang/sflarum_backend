package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.DiscussionView;
import cn.nopj.sflarum.domian.repository.DiscussionViewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DiscussionViewService {
    private final DiscussionViewRepository repository;
    public DiscussionView findById(Long id) {
        return repository.findById(id);
    }
    public List<DiscussionView> listAll() {
        return repository.findAll();
    }
    public boolean create(DiscussionView entity) {
        return repository.create(entity);
    }
    public boolean update(DiscussionView entity) {
        return repository.update(entity);
    }
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}