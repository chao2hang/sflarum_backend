package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.DiscussionUser;
import cn.nopj.sflarum.domian.entity.key.DiscussionUserKey;
import cn.nopj.sflarum.domian.repository.DiscussionUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class DiscussionUserService {
    private final DiscussionUserRepository repository;
    public DiscussionUser findById(DiscussionUserKey key) {
        return repository.findById(key);
    }
    public List<DiscussionUser> listAll() {
        return repository.findAll();
    }
    public boolean create(DiscussionUser entity) {
        return repository.create(entity);
    }
    public boolean update(DiscussionUser entity) {
        return repository.update(entity);
    }
    public boolean delete(DiscussionUserKey key) {
        return repository.delete(key);
    }
}