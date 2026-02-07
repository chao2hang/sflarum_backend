package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.Discussion;
import java.util.List;
public interface DiscussionRepository {
    Discussion findById(Long id);
    List<Discussion> findAll();
    boolean create(Discussion entity);
    boolean update(Discussion entity);
    boolean delete(Long id);
}