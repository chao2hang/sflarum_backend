package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.Group;
import cn.nopj.sflarum.domian.repository.GroupRepository;
import cn.nopj.sflarum.infra.mapper.GroupMapper;
import cn.nopj.sflarum.infra.po.GroupPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class GroupRepositoryImpl implements GroupRepository {
    private final GroupMapper mapper;
    @Override
    public Group findById(Long id) {
        GroupPo po = mapper.findById(id);
        if (po == null) {
            return null;
        }
        Group entity = new Group();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<Group> findAll() {
        List<GroupPo> list = mapper.findAll();
        List<Group> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (GroupPo po : list) {
            Group entity = new Group();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(Group entity) {
        GroupPo po = new GroupPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(Group entity) {
        GroupPo po = new GroupPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(Long id) {
        return mapper.deleteById(id) > 0;
    }
}