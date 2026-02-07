package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.Poll;
import java.util.List;
public interface PollRepository {
    Poll findById(Long id);
    List<Poll> findAll();
    boolean create(Poll entity);
    boolean update(Poll entity);
    boolean delete(Long id);
}