package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.GroupUser;
import cn.nopj.sflarum.domian.entity.key.GroupUserKey;
import cn.nopj.sflarum.domian.repository.GroupUserRepository;
import cn.nopj.sflarum.infra.mapper.GroupUserMapper;
import cn.nopj.sflarum.infra.po.GroupUserPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class GroupUserRepositoryImpl implements GroupUserRepository {
    private final GroupUserMapper mapper;
    @Override
    public GroupUser findById(GroupUserKey key) {
        GroupUserPo po = mapper.findById(key);
        if (po == null) {
            return null;
        }
        GroupUser entity = new GroupUser();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<GroupUser> findAll() {
        List<GroupUserPo> list = mapper.findAll();
        List<GroupUser> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (GroupUserPo po : list) {
            GroupUser entity = new GroupUser();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(GroupUser entity) {
        GroupUserPo po = new GroupUserPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(GroupUser entity) {
        GroupUserPo po = new GroupUserPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(GroupUserKey key) {
        return mapper.deleteById(key) > 0;
    }
}