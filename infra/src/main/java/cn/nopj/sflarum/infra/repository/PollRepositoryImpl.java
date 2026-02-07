package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.Poll;
import cn.nopj.sflarum.domian.repository.PollRepository;
import cn.nopj.sflarum.infra.mapper.PollMapper;
import cn.nopj.sflarum.infra.po.PollPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class PollRepositoryImpl implements PollRepository {
    private final PollMapper mapper;
    @Override
    public Poll findById(Long id) {
        PollPo po = mapper.findById(id);
        if (po == null) {
            return null;
        }
        Poll entity = new Poll();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<Poll> findAll() {
        List<PollPo> list = mapper.findAll();
        List<Poll> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (PollPo po : list) {
            Poll entity = new Poll();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(Poll entity) {
        PollPo po = new PollPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(Poll entity) {
        PollPo po = new PollPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(Long id) {
        return mapper.deleteById(id) > 0;
    }
}