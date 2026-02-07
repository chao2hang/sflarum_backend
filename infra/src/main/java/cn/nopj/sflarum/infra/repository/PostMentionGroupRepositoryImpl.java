package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.PostMentionGroup;
import cn.nopj.sflarum.domian.entity.key.PostMentionGroupKey;
import cn.nopj.sflarum.domian.repository.PostMentionGroupRepository;
import cn.nopj.sflarum.infra.mapper.PostMentionGroupMapper;
import cn.nopj.sflarum.infra.po.PostMentionGroupPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class PostMentionGroupRepositoryImpl implements PostMentionGroupRepository {
    private final PostMentionGroupMapper mapper;
    @Override
    public PostMentionGroup findById(PostMentionGroupKey key) {
        PostMentionGroupPo po = mapper.findById(key);
        if (po == null) {
            return null;
        }
        PostMentionGroup entity = new PostMentionGroup();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<PostMentionGroup> findAll() {
        List<PostMentionGroupPo> list = mapper.findAll();
        List<PostMentionGroup> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (PostMentionGroupPo po : list) {
            PostMentionGroup entity = new PostMentionGroup();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(PostMentionGroup entity) {
        PostMentionGroupPo po = new PostMentionGroupPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(PostMentionGroup entity) {
        PostMentionGroupPo po = new PostMentionGroupPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(PostMentionGroupKey key) {
        return mapper.deleteById(key) > 0;
    }
}