package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.CriterionUser;
import cn.nopj.sflarum.domian.entity.key.CriterionUserKey;
import cn.nopj.sflarum.domian.repository.CriterionUserRepository;
import cn.nopj.sflarum.infra.mapper.CriterionUserMapper;
import cn.nopj.sflarum.infra.po.CriterionUserPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class CriterionUserRepositoryImpl implements CriterionUserRepository {
    private final CriterionUserMapper mapper;
    @Override
    public CriterionUser findById(CriterionUserKey key) {
        CriterionUserPo po = mapper.findById(key);
        if (po == null) {
            return null;
        }
        CriterionUser entity = new CriterionUser();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<CriterionUser> findAll() {
        List<CriterionUserPo> list = mapper.findAll();
        List<CriterionUser> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (CriterionUserPo po : list) {
            CriterionUser entity = new CriterionUser();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(CriterionUser entity) {
        CriterionUserPo po = new CriterionUserPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(CriterionUser entity) {
        CriterionUserPo po = new CriterionUserPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(CriterionUserKey key) {
        return mapper.deleteById(key) > 0;
    }
}