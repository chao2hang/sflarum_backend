package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.DiscussionView;
import cn.nopj.sflarum.domian.repository.DiscussionViewRepository;
import cn.nopj.sflarum.infra.mapper.DiscussionViewMapper;
import cn.nopj.sflarum.infra.po.DiscussionViewPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class DiscussionViewRepositoryImpl implements DiscussionViewRepository {
    private final DiscussionViewMapper mapper;
    @Override
    public DiscussionView findById(Long id) {
        DiscussionViewPo po = mapper.findById(id);
        if (po == null) {
            return null;
        }
        DiscussionView entity = new DiscussionView();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<DiscussionView> findAll() {
        List<DiscussionViewPo> list = mapper.findAll();
        List<DiscussionView> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (DiscussionViewPo po : list) {
            DiscussionView entity = new DiscussionView();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(DiscussionView entity) {
        DiscussionViewPo po = new DiscussionViewPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(DiscussionView entity) {
        DiscussionViewPo po = new DiscussionViewPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(Long id) {
        return mapper.deleteById(id) > 0;
    }
}