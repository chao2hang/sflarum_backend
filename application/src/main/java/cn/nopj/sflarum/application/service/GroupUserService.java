package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.GroupUser;
import cn.nopj.sflarum.domian.entity.key.GroupUserKey;
import cn.nopj.sflarum.domian.repository.GroupUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class GroupUserService {
    private final GroupUserRepository repository;
    public GroupUser findById(GroupUserKey key) {
        return repository.findById(key);
    }
    public List<GroupUser> listAll() {
        return repository.findAll();
    }
    public boolean create(GroupUser entity) {
        return repository.create(entity);
    }
    public boolean update(GroupUser entity) {
        return repository.update(entity);
    }
    public boolean delete(GroupUserKey key) {
        return repository.delete(key);
    }
}