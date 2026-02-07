package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.RankUser;
import cn.nopj.sflarum.domian.entity.key.RankUserKey;
import cn.nopj.sflarum.domian.repository.RankUserRepository;
import cn.nopj.sflarum.infra.mapper.RankUserMapper;
import cn.nopj.sflarum.infra.po.RankUserPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class RankUserRepositoryImpl implements RankUserRepository {
    private final RankUserMapper mapper;
    @Override
    public RankUser findById(RankUserKey key) {
        RankUserPo po = mapper.findById(key);
        if (po == null) {
            return null;
        }
        RankUser entity = new RankUser();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<RankUser> findAll() {
        List<RankUserPo> list = mapper.findAll();
        List<RankUser> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (RankUserPo po : list) {
            RankUser entity = new RankUser();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(RankUser entity) {
        RankUserPo po = new RankUserPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(RankUser entity) {
        RankUserPo po = new RankUserPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(RankUserKey key) {
        return mapper.deleteById(key) > 0;
    }
}