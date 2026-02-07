package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.Post;
import cn.nopj.sflarum.domian.repository.PostRepository;
import cn.nopj.sflarum.infra.mapper.PostMapper;
import cn.nopj.sflarum.infra.po.PostPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {
    private final PostMapper mapper;
    @Override
    public Post findById(Long id) {
        PostPo po = mapper.findById(id);
        if (po == null) {
            return null;
        }
        Post entity = new Post();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<Post> findAll() {
        List<PostPo> list = mapper.findAll();
        List<Post> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (PostPo po : list) {
            Post entity = new Post();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(Post entity) {
        PostPo po = new PostPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(Post entity) {
        PostPo po = new PostPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(Long id) {
        return mapper.deleteById(id) > 0;
    }
}