package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.PostMentionTag;
import cn.nopj.sflarum.domian.entity.key.PostMentionTagKey;
import cn.nopj.sflarum.domian.repository.PostMentionTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PostMentionTagService {
    private final PostMentionTagRepository repository;
    public PostMentionTag findById(PostMentionTagKey key) {
        return repository.findById(key);
    }
    public List<PostMentionTag> listAll() {
        return repository.findAll();
    }
    public boolean create(PostMentionTag entity) {
        return repository.create(entity);
    }
    public boolean update(PostMentionTag entity) {
        return repository.update(entity);
    }
    public boolean delete(PostMentionTagKey key) {
        return repository.delete(key);
    }
}