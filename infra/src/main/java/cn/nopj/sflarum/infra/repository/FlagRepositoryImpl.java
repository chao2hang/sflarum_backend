package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.Flag;
import cn.nopj.sflarum.domian.repository.FlagRepository;
import cn.nopj.sflarum.infra.mapper.FlagMapper;
import cn.nopj.sflarum.infra.po.FlagPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class FlagRepositoryImpl implements FlagRepository {
    private final FlagMapper mapper;
    @Override
    public Flag findById(Long id) {
        FlagPo po = mapper.findById(id);
        if (po == null) {
            return null;
        }
        Flag entity = new Flag();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<Flag> findAll() {
        List<FlagPo> list = mapper.findAll();
        List<Flag> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (FlagPo po : list) {
            Flag entity = new Flag();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(Flag entity) {
        FlagPo po = new FlagPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(Flag entity) {
        FlagPo po = new FlagPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(Long id) {
        return mapper.deleteById(id) > 0;
    }
}