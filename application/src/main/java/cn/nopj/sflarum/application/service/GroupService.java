package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.Group;
import cn.nopj.sflarum.domian.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository repository;
    public Group findById(Long id) {
        return repository.findById(id);
    }
    public List<Group> listAll() {
        return repository.findAll();
    }
    public boolean create(Group entity) {
        return repository.create(entity);
    }
    public boolean update(Group entity) {
        return repository.update(entity);
    }
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}