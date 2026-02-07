package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.Post;
import java.util.List;
public interface PostRepository {
    Post findById(Long id);
    List<Post> findAll();
    boolean create(Post entity);
    boolean update(Post entity);
    boolean delete(Long id);
}