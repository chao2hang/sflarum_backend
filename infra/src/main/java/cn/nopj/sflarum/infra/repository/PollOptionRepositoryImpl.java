package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.PollOption;
import cn.nopj.sflarum.domian.repository.PollOptionRepository;
import cn.nopj.sflarum.infra.mapper.PollOptionMapper;
import cn.nopj.sflarum.infra.po.PollOptionPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class PollOptionRepositoryImpl implements PollOptionRepository {
    private final PollOptionMapper mapper;
    @Override
    public PollOption findById(Long id) {
        PollOptionPo po = mapper.findById(id);
        if (po == null) {
            return null;
        }
        PollOption entity = new PollOption();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<PollOption> findAll() {
        List<PollOptionPo> list = mapper.findAll();
        List<PollOption> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (PollOptionPo po : list) {
            PollOption entity = new PollOption();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(PollOption entity) {
        PollOptionPo po = new PollOptionPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(PollOption entity) {
        PollOptionPo po = new PollOptionPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(Long id) {
        return mapper.deleteById(id) > 0;
    }
}