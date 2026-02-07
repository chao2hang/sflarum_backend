package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.PostLike;
import cn.nopj.sflarum.domian.entity.key.PostLikeKey;
import java.util.List;
public interface PostLikeRepository {
    PostLike findById(PostLikeKey key);
    List<PostLike> findAll();
    boolean create(PostLike entity);
    boolean update(PostLike entity);
    boolean delete(PostLikeKey key);
}