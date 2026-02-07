package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.PostMentionPost;
import cn.nopj.sflarum.domian.entity.key.PostMentionPostKey;
import cn.nopj.sflarum.domian.repository.PostMentionPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PostMentionPostService {
    private final PostMentionPostRepository repository;
    public PostMentionPost findById(PostMentionPostKey key) {
        return repository.findById(key);
    }
    public List<PostMentionPost> listAll() {
        return repository.findAll();
    }
    public boolean create(PostMentionPost entity) {
        return repository.create(entity);
    }
    public boolean update(PostMentionPost entity) {
        return repository.update(entity);
    }
    public boolean delete(PostMentionPostKey key) {
        return repository.delete(key);
    }
}