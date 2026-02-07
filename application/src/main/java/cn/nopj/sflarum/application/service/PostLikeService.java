package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.PostLike;
import cn.nopj.sflarum.domian.entity.key.PostLikeKey;
import cn.nopj.sflarum.domian.repository.PostLikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PostLikeService {
    private final PostLikeRepository repository;
    public PostLike findById(PostLikeKey key) {
        return repository.findById(key);
    }
    public List<PostLike> listAll() {
        return repository.findAll();
    }
    public boolean create(PostLike entity) {
        return repository.create(entity);
    }
    public boolean update(PostLike entity) {
        return repository.update(entity);
    }
    public boolean delete(PostLikeKey key) {
        return repository.delete(key);
    }
}