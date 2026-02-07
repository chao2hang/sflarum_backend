package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.PostMentionTag;
import cn.nopj.sflarum.domian.entity.key.PostMentionTagKey;
import cn.nopj.sflarum.domian.repository.PostMentionTagRepository;
import cn.nopj.sflarum.infra.mapper.PostMentionTagMapper;
import cn.nopj.sflarum.infra.po.PostMentionTagPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class PostMentionTagRepositoryImpl implements PostMentionTagRepository {
    private final PostMentionTagMapper mapper;
    @Override
    public PostMentionTag findById(PostMentionTagKey key) {
        PostMentionTagPo po = mapper.findById(key);
        if (po == null) {
            return null;
        }
        PostMentionTag entity = new PostMentionTag();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<PostMentionTag> findAll() {
        List<PostMentionTagPo> list = mapper.findAll();
        List<PostMentionTag> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (PostMentionTagPo po : list) {
            PostMentionTag entity = new PostMentionTag();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(PostMentionTag entity) {
        PostMentionTagPo po = new PostMentionTagPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(PostMentionTag entity) {
        PostMentionTagPo po = new PostMentionTagPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(PostMentionTagKey key) {
        return mapper.deleteById(key) > 0;
    }
}