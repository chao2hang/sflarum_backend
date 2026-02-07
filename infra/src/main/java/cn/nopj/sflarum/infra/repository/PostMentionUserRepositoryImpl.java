package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.PostMentionUser;
import cn.nopj.sflarum.domian.entity.key.PostMentionUserKey;
import cn.nopj.sflarum.domian.repository.PostMentionUserRepository;
import cn.nopj.sflarum.infra.mapper.PostMentionUserMapper;
import cn.nopj.sflarum.infra.po.PostMentionUserPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class PostMentionUserRepositoryImpl implements PostMentionUserRepository {
    private final PostMentionUserMapper mapper;
    @Override
    public PostMentionUser findById(PostMentionUserKey key) {
        PostMentionUserPo po = mapper.findById(key);
        if (po == null) {
            return null;
        }
        PostMentionUser entity = new PostMentionUser();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<PostMentionUser> findAll() {
        List<PostMentionUserPo> list = mapper.findAll();
        List<PostMentionUser> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (PostMentionUserPo po : list) {
            PostMentionUser entity = new PostMentionUser();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(PostMentionUser entity) {
        PostMentionUserPo po = new PostMentionUserPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(PostMentionUser entity) {
        PostMentionUserPo po = new PostMentionUserPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(PostMentionUserKey key) {
        return mapper.deleteById(key) > 0;
    }
}