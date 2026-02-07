package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.PostVote;
import cn.nopj.sflarum.domian.repository.PostVoteRepository;
import cn.nopj.sflarum.infra.mapper.PostVoteMapper;
import cn.nopj.sflarum.infra.po.PostVotePo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class PostVoteRepositoryImpl implements PostVoteRepository {
    private final PostVoteMapper mapper;
    @Override
    public PostVote findById(Long id) {
        PostVotePo po = mapper.findById(id);
        if (po == null) {
            return null;
        }
        PostVote entity = new PostVote();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<PostVote> findAll() {
        List<PostVotePo> list = mapper.findAll();
        List<PostVote> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (PostVotePo po : list) {
            PostVote entity = new PostVote();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(PostVote entity) {
        PostVotePo po = new PostVotePo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(PostVote entity) {
        PostVotePo po = new PostVotePo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(Long id) {
        return mapper.deleteById(id) > 0;
    }
}