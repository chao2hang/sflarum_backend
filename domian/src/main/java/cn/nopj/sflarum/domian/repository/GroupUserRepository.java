package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.GroupUser;
import cn.nopj.sflarum.domian.entity.key.GroupUserKey;
import java.util.List;
public interface GroupUserRepository {
    GroupUser findById(GroupUserKey key);
    List<GroupUser> findAll();
    boolean create(GroupUser entity);
    boolean update(GroupUser entity);
    boolean delete(GroupUserKey key);
}