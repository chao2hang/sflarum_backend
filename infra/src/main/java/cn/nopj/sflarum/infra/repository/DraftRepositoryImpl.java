package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.Draft;
import cn.nopj.sflarum.domian.repository.DraftRepository;
import cn.nopj.sflarum.infra.mapper.DraftMapper;
import cn.nopj.sflarum.infra.po.DraftPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class DraftRepositoryImpl implements DraftRepository {
    private final DraftMapper mapper;
    @Override
    public Draft findById(Long id) {
        DraftPo po = mapper.findById(id);
        if (po == null) {
            return null;
        }
        Draft entity = new Draft();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<Draft> findAll() {
        List<DraftPo> list = mapper.findAll();
        List<Draft> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (DraftPo po : list) {
            Draft entity = new Draft();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(Draft entity) {
        DraftPo po = new DraftPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(Draft entity) {
        DraftPo po = new DraftPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(Long id) {
        return mapper.deleteById(id) > 0;
    }
}