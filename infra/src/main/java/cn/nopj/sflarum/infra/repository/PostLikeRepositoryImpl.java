package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.PostLike;
import cn.nopj.sflarum.domian.entity.key.PostLikeKey;
import cn.nopj.sflarum.domian.repository.PostLikeRepository;
import cn.nopj.sflarum.infra.mapper.PostLikeMapper;
import cn.nopj.sflarum.infra.po.PostLikePo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class PostLikeRepositoryImpl implements PostLikeRepository {
    private final PostLikeMapper mapper;
    @Override
    public PostLike findById(PostLikeKey key) {
        PostLikePo po = mapper.findById(key);
        if (po == null) {
            return null;
        }
        PostLike entity = new PostLike();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<PostLike> findAll() {
        List<PostLikePo> list = mapper.findAll();
        List<PostLike> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (PostLikePo po : list) {
            PostLike entity = new PostLike();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(PostLike entity) {
        PostLikePo po = new PostLikePo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(PostLike entity) {
        PostLikePo po = new PostLikePo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(PostLikeKey key) {
        return mapper.deleteById(key) > 0;
    }
}