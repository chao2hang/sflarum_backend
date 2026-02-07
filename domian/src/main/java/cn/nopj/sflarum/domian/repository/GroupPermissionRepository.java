package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.GroupPermission;
import cn.nopj.sflarum.domian.entity.key.GroupPermissionKey;
import java.util.List;
public interface GroupPermissionRepository {
    GroupPermission findById(GroupPermissionKey key);
    List<GroupPermission> findAll();
    boolean create(GroupPermission entity);
    boolean update(GroupPermission entity);
    boolean delete(GroupPermissionKey key);
}