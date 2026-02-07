package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.PostMentionGroup;
import cn.nopj.sflarum.domian.entity.key.PostMentionGroupKey;
import cn.nopj.sflarum.domian.repository.PostMentionGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PostMentionGroupService {
    private final PostMentionGroupRepository repository;
    public PostMentionGroup findById(PostMentionGroupKey key) {
        return repository.findById(key);
    }
    public List<PostMentionGroup> listAll() {
        return repository.findAll();
    }
    public boolean create(PostMentionGroup entity) {
        return repository.create(entity);
    }
    public boolean update(PostMentionGroup entity) {
        return repository.update(entity);
    }
    public boolean delete(PostMentionGroupKey key) {
        return repository.delete(key);
    }
}