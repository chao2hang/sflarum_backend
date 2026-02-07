package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.BadgeUser;
import cn.nopj.sflarum.domian.repository.BadgeUserRepository;
import cn.nopj.sflarum.infra.mapper.BadgeUserMapper;
import cn.nopj.sflarum.infra.po.BadgeUserPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class BadgeUserRepositoryImpl implements BadgeUserRepository {
    private final BadgeUserMapper mapper;
    @Override
    public BadgeUser findById(Long id) {
        BadgeUserPo po = mapper.findById(id);
        if (po == null) {
            return null;
        }
        BadgeUser entity = new BadgeUser();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<BadgeUser> findAll() {
        List<BadgeUserPo> list = mapper.findAll();
        List<BadgeUser> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (BadgeUserPo po : list) {
            BadgeUser entity = new BadgeUser();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(BadgeUser entity) {
        BadgeUserPo po = new BadgeUserPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(BadgeUser entity) {
        BadgeUserPo po = new BadgeUserPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(Long id) {
        return mapper.deleteById(id) > 0;
    }
}