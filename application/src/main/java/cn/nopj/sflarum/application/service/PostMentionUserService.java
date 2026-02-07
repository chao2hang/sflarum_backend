package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.PostMentionUser;
import cn.nopj.sflarum.domian.entity.key.PostMentionUserKey;
import cn.nopj.sflarum.domian.repository.PostMentionUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PostMentionUserService {
    private final PostMentionUserRepository repository;
    public PostMentionUser findById(PostMentionUserKey key) {
        return repository.findById(key);
    }
    public List<PostMentionUser> listAll() {
        return repository.findAll();
    }
    public boolean create(PostMentionUser entity) {
        return repository.create(entity);
    }
    public boolean update(PostMentionUser entity) {
        return repository.update(entity);
    }
    public boolean delete(PostMentionUserKey key) {
        return repository.delete(key);
    }
}