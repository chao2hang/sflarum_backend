package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.PostVote;
import java.util.List;
public interface PostVoteRepository {
    PostVote findById(Long id);
    List<PostVote> findAll();
    boolean create(PostVote entity);
    boolean update(PostVote entity);
    boolean delete(Long id);
}