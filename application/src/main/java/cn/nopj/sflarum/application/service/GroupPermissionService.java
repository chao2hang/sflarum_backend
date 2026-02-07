package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.GroupPermission;
import cn.nopj.sflarum.domian.entity.key.GroupPermissionKey;
import cn.nopj.sflarum.domian.repository.GroupPermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class GroupPermissionService {
    private final GroupPermissionRepository repository;
    public GroupPermission findById(GroupPermissionKey key) {
        return repository.findById(key);
    }
    public List<GroupPermission> listAll() {
        return repository.findAll();
    }
    public boolean create(GroupPermission entity) {
        return repository.create(entity);
    }
    public boolean update(GroupPermission entity) {
        return repository.update(entity);
    }
    public boolean delete(GroupPermissionKey key) {
        return repository.delete(key);
    }
}