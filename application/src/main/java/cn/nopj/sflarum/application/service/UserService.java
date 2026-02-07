package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.User;
import cn.nopj.sflarum.domian.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    public User findById(Long id) {
        return repository.findById(id);
    }
    public List<User> listAll() {
        return repository.findAll();
    }
    public boolean create(User entity) {
        return repository.create(entity);
    }
    public boolean update(User entity) {
        return repository.update(entity);
    }
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}