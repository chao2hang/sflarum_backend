package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.PostUser;
import cn.nopj.sflarum.domian.entity.key.PostUserKey;
import cn.nopj.sflarum.domian.repository.PostUserRepository;
import cn.nopj.sflarum.infra.mapper.PostUserMapper;
import cn.nopj.sflarum.infra.po.PostUserPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class PostUserRepositoryImpl implements PostUserRepository {
    private final PostUserMapper mapper;
    @Override
    public PostUser findById(PostUserKey key) {
        PostUserPo po = mapper.findById(key);
        if (po == null) {
            return null;
        }
        PostUser entity = new PostUser();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<PostUser> findAll() {
        List<PostUserPo> list = mapper.findAll();
        List<PostUser> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (PostUserPo po : list) {
            PostUser entity = new PostUser();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(PostUser entity) {
        PostUserPo po = new PostUserPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(PostUser entity) {
        PostUserPo po = new PostUserPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(PostUserKey key) {
        return mapper.deleteById(key) > 0;
    }
}