package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.PostUser;
import cn.nopj.sflarum.domian.entity.key.PostUserKey;
import cn.nopj.sflarum.domian.repository.PostUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PostUserService {
    private final PostUserRepository repository;
    public PostUser findById(PostUserKey key) {
        return repository.findById(key);
    }
    public List<PostUser> listAll() {
        return repository.findAll();
    }
    public boolean create(PostUser entity) {
        return repository.create(entity);
    }
    public boolean update(PostUser entity) {
        return repository.update(entity);
    }
    public boolean delete(PostUserKey key) {
        return repository.delete(key);
    }
}