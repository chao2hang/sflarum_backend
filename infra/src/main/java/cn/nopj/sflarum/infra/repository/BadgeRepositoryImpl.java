package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.Badge;
import cn.nopj.sflarum.domian.repository.BadgeRepository;
import cn.nopj.sflarum.infra.mapper.BadgeMapper;
import cn.nopj.sflarum.infra.po.BadgePo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class BadgeRepositoryImpl implements BadgeRepository {
    private final BadgeMapper mapper;
    @Override
    public Badge findById(Long id) {
        BadgePo po = mapper.findById(id);
        if (po == null) {
            return null;
        }
        Badge entity = new Badge();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<Badge> findAll() {
        List<BadgePo> list = mapper.findAll();
        List<Badge> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (BadgePo po : list) {
            Badge entity = new Badge();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(Badge entity) {
        BadgePo po = new BadgePo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(Badge entity) {
        BadgePo po = new BadgePo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(Long id) {
        return mapper.deleteById(id) > 0;
    }
}