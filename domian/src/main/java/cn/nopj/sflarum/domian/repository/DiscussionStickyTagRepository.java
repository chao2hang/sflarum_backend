package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.DiscussionStickyTag;
import cn.nopj.sflarum.domian.entity.key.DiscussionStickyTagKey;
import java.util.List;
public interface DiscussionStickyTagRepository {
    DiscussionStickyTag findById(DiscussionStickyTagKey key);
    List<DiscussionStickyTag> findAll();
    boolean create(DiscussionStickyTag entity);
    boolean update(DiscussionStickyTag entity);
    boolean delete(DiscussionStickyTagKey key);
}