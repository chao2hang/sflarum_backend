package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.Tag;
import cn.nopj.sflarum.domian.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository repository;
    public Tag findById(Long id) {
        return repository.findById(id);
    }
    public List<Tag> listAll() {
        return repository.findAll();
    }
    public boolean create(Tag entity) {
        return repository.create(entity);
    }
    public boolean update(Tag entity) {
        return repository.update(entity);
    }
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}