package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.DiscussionTag;
import cn.nopj.sflarum.domian.entity.key.DiscussionTagKey;
import java.util.List;
public interface DiscussionTagRepository {
    DiscussionTag findById(DiscussionTagKey key);
    List<DiscussionTag> findAll();
    boolean create(DiscussionTag entity);
    boolean update(DiscussionTag entity);
    boolean delete(DiscussionTagKey key);
}