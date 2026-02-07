package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.Post;
import cn.nopj.sflarum.domian.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repository;
    public Post findById(Long id) {
        return repository.findById(id);
    }
    public List<Post> listAll() {
        return repository.findAll();
    }
    public boolean create(Post entity) {
        return repository.create(entity);
    }
    public boolean update(Post entity) {
        return repository.update(entity);
    }
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}