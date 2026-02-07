package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.DiscussionTag;
import cn.nopj.sflarum.domian.entity.key.DiscussionTagKey;
import cn.nopj.sflarum.domian.repository.DiscussionTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DiscussionTagService {
    private final DiscussionTagRepository repository;
    public DiscussionTag findById(DiscussionTagKey key) {
        return repository.findById(key);
    }
    public List<DiscussionTag> listAll() {
        return repository.findAll();
    }
    public boolean create(DiscussionTag entity) {
        return repository.create(entity);
    }
    public boolean update(DiscussionTag entity) {
        return repository.update(entity);
    }
    public boolean delete(DiscussionTagKey key) {
        return repository.delete(key);
    }
}