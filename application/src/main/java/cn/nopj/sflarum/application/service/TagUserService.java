package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.TagUser;
import cn.nopj.sflarum.domian.entity.key.TagUserKey;
import cn.nopj.sflarum.domian.repository.TagUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class TagUserService {
    private final TagUserRepository repository;
    public TagUser findById(TagUserKey key) {
        return repository.findById(key);
    }
    public List<TagUser> listAll() {
        return repository.findAll();
    }
    public boolean create(TagUser entity) {
        return repository.create(entity);
    }
    public boolean update(TagUser entity) {
        return repository.update(entity);
    }
    public boolean delete(TagUserKey key) {
        return repository.delete(key);
    }
}