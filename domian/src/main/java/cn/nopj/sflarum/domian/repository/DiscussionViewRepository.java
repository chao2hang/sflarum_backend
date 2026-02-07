package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.DiscussionView;
import java.util.List;
public interface DiscussionViewRepository {
    DiscussionView findById(Long id);
    List<DiscussionView> findAll();
    boolean create(DiscussionView entity);
    boolean update(DiscussionView entity);
    boolean delete(Long id);
}