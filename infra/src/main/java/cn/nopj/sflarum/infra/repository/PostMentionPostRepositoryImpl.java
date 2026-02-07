package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.PostMentionPost;
import cn.nopj.sflarum.domian.entity.key.PostMentionPostKey;
import cn.nopj.sflarum.domian.repository.PostMentionPostRepository;
import cn.nopj.sflarum.infra.mapper.PostMentionPostMapper;
import cn.nopj.sflarum.infra.po.PostMentionPostPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class PostMentionPostRepositoryImpl implements PostMentionPostRepository {
    private final PostMentionPostMapper mapper;
    @Override
    public PostMentionPost findById(PostMentionPostKey key) {
        PostMentionPostPo po = mapper.findById(key);
        if (po == null) {
            return null;
        }
        PostMentionPost entity = new PostMentionPost();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<PostMentionPost> findAll() {
        List<PostMentionPostPo> list = mapper.findAll();
        List<PostMentionPost> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (PostMentionPostPo po : list) {
            PostMentionPost entity = new PostMentionPost();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(PostMentionPost entity) {
        PostMentionPostPo po = new PostMentionPostPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(PostMentionPost entity) {
        PostMentionPostPo po = new PostMentionPostPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(PostMentionPostKey key) {
        return mapper.deleteById(key) > 0;
    }
}