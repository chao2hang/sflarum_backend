package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.PollOption;
import java.util.List;
public interface PollOptionRepository {
    PollOption findById(Long id);
    List<PollOption> findAll();
    boolean create(PollOption entity);
    boolean update(PollOption entity);
    boolean delete(Long id);
}