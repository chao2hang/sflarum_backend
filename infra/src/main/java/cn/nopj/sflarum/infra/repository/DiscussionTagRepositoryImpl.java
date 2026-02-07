package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.DiscussionTag;
import cn.nopj.sflarum.domian.entity.key.DiscussionTagKey;
import cn.nopj.sflarum.domian.repository.DiscussionTagRepository;
import cn.nopj.sflarum.infra.mapper.DiscussionTagMapper;
import cn.nopj.sflarum.infra.po.DiscussionTagPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class DiscussionTagRepositoryImpl implements DiscussionTagRepository {
    private final DiscussionTagMapper mapper;
    @Override
    public DiscussionTag findById(DiscussionTagKey key) {
        DiscussionTagPo po = mapper.findById(key);
        if (po == null) {
            return null;
        }
        DiscussionTag entity = new DiscussionTag();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<DiscussionTag> findAll() {
        List<DiscussionTagPo> list = mapper.findAll();
        List<DiscussionTag> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (DiscussionTagPo po : list) {
            DiscussionTag entity = new DiscussionTag();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(DiscussionTag entity) {
        DiscussionTagPo po = new DiscussionTagPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(DiscussionTag entity) {
        DiscussionTagPo po = new DiscussionTagPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(DiscussionTagKey key) {
        return mapper.deleteById(key) > 0;
    }
}