package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.DiscussionStickyTag;
import cn.nopj.sflarum.domian.entity.key.DiscussionStickyTagKey;
import cn.nopj.sflarum.domian.repository.DiscussionStickyTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DiscussionStickyTagService {
    private final DiscussionStickyTagRepository repository;
    public DiscussionStickyTag findById(DiscussionStickyTagKey key) {
        return repository.findById(key);
    }
    public List<DiscussionStickyTag> listAll() {
        return repository.findAll();
    }
    public boolean create(DiscussionStickyTag entity) {
        return repository.create(entity);
    }
    public boolean update(DiscussionStickyTag entity) {
        return repository.update(entity);
    }
    public boolean delete(DiscussionStickyTagKey key) {
        return repository.delete(key);
    }
}