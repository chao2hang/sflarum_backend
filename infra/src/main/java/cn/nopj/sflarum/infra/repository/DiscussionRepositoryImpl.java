package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.Discussion;
import cn.nopj.sflarum.domian.repository.DiscussionRepository;
import cn.nopj.sflarum.infra.mapper.DiscussionMapper;
import cn.nopj.sflarum.infra.po.DiscussionPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class DiscussionRepositoryImpl implements DiscussionRepository {
    private final DiscussionMapper mapper;
    @Override
    public Discussion findById(Long id) {
        DiscussionPo po = mapper.findById(id);
        if (po == null) {
            return null;
        }
        Discussion entity = new Discussion();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<Discussion> findAll() {
        List<DiscussionPo> list = mapper.findAll();
        List<Discussion> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (DiscussionPo po : list) {
            Discussion entity = new Discussion();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(Discussion entity) {
        DiscussionPo po = new DiscussionPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(Discussion entity) {
        DiscussionPo po = new DiscussionPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(Long id) {
        return mapper.deleteById(id) > 0;
    }
}