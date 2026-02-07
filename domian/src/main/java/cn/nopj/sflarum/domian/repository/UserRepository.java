package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.User;
import java.util.List;
public interface UserRepository {
    User findById(Long id);
    List<User> findAll();
    boolean create(User entity);
    boolean update(User entity);
    boolean delete(Long id);
}