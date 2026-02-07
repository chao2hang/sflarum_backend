package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.PollVote;
import java.util.List;
public interface PollVoteRepository {
    PollVote findById(Long id);
    List<PollVote> findAll();
    boolean create(PollVote entity);
    boolean update(PollVote entity);
    boolean delete(Long id);
}