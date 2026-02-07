package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.DiscussionStickyTag;
import cn.nopj.sflarum.domian.entity.key.DiscussionStickyTagKey;
import cn.nopj.sflarum.domian.repository.DiscussionStickyTagRepository;
import cn.nopj.sflarum.infra.mapper.DiscussionStickyTagMapper;
import cn.nopj.sflarum.infra.po.DiscussionStickyTagPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class DiscussionStickyTagRepositoryImpl implements DiscussionStickyTagRepository {
    private final DiscussionStickyTagMapper mapper;
    @Override
    public DiscussionStickyTag findById(DiscussionStickyTagKey key) {
        DiscussionStickyTagPo po = mapper.findById(key);
        if (po == null) {
            return null;
        }
        DiscussionStickyTag entity = new DiscussionStickyTag();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<DiscussionStickyTag> findAll() {
        List<DiscussionStickyTagPo> list = mapper.findAll();
        List<DiscussionStickyTag> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (DiscussionStickyTagPo po : list) {
            DiscussionStickyTag entity = new DiscussionStickyTag();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(DiscussionStickyTag entity) {
        DiscussionStickyTagPo po = new DiscussionStickyTagPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(DiscussionStickyTag entity) {
        DiscussionStickyTagPo po = new DiscussionStickyTagPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(DiscussionStickyTagKey key) {
        return mapper.deleteById(key) > 0;
    }
}