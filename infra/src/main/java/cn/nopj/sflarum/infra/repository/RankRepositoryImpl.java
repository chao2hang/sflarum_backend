package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.Rank;
import cn.nopj.sflarum.domian.repository.RankRepository;
import cn.nopj.sflarum.infra.mapper.RankMapper;
import cn.nopj.sflarum.infra.po.RankPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class RankRepositoryImpl implements RankRepository {
    private final RankMapper mapper;
    @Override
    public Rank findById(Long id) {
        RankPo po = mapper.findById(id);
        if (po == null) {
            return null;
        }
        Rank entity = new Rank();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<Rank> findAll() {
        List<RankPo> list = mapper.findAll();
        List<Rank> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (RankPo po : list) {
            Rank entity = new Rank();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(Rank entity) {
        RankPo po = new RankPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(Rank entity) {
        RankPo po = new RankPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(Long id) {
        return mapper.deleteById(id) > 0;
    }
}