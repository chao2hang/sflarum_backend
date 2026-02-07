package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.Group;
import java.util.List;
public interface GroupRepository {
    Group findById(Long id);
    List<Group> findAll();
    boolean create(Group entity);
    boolean update(Group entity);
    boolean delete(Long id);
}