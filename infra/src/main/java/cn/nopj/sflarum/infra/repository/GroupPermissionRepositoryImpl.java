package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.GroupPermission;
import cn.nopj.sflarum.domian.entity.key.GroupPermissionKey;
import cn.nopj.sflarum.domian.repository.GroupPermissionRepository;
import cn.nopj.sflarum.infra.mapper.GroupPermissionMapper;
import cn.nopj.sflarum.infra.po.GroupPermissionPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class GroupPermissionRepositoryImpl implements GroupPermissionRepository {
    private final GroupPermissionMapper mapper;
    @Override
    public GroupPermission findById(GroupPermissionKey key) {
        GroupPermissionPo po = mapper.findById(key);
        if (po == null) {
            return null;
        }
        GroupPermission entity = new GroupPermission();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<GroupPermission> findAll() {
        List<GroupPermissionPo> list = mapper.findAll();
        List<GroupPermission> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (GroupPermissionPo po : list) {
            GroupPermission entity = new GroupPermission();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(GroupPermission entity) {
        GroupPermissionPo po = new GroupPermissionPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(GroupPermission entity) {
        GroupPermissionPo po = new GroupPermissionPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(GroupPermissionKey key) {
        return mapper.deleteById(key) > 0;
    }
}