package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.PollVote;
import cn.nopj.sflarum.domian.repository.PollVoteRepository;
import cn.nopj.sflarum.infra.mapper.PollVoteMapper;
import cn.nopj.sflarum.infra.po.PollVotePo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class PollVoteRepositoryImpl implements PollVoteRepository {
    private final PollVoteMapper mapper;
    @Override
    public PollVote findById(Long id) {
        PollVotePo po = mapper.findById(id);
        if (po == null) {
            return null;
        }
        PollVote entity = new PollVote();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<PollVote> findAll() {
        List<PollVotePo> list = mapper.findAll();
        List<PollVote> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (PollVotePo po : list) {
            PollVote entity = new PollVote();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(PollVote entity) {
        PollVotePo po = new PollVotePo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(PollVote entity) {
        PollVotePo po = new PollVotePo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(Long id) {
        return mapper.deleteById(id) > 0;
    }
}