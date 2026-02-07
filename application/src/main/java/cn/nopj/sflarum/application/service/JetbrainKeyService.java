package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.JetbrainKey;
import cn.nopj.sflarum.domian.repository.JetbrainKeyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class JetbrainKeyService {
    private final JetbrainKeyRepository repository;
    public JetbrainKey findById(Integer id) {
        return repository.findById(id);
    }
    public List<JetbrainKey> listAll() {
        return repository.findAll();
    }
    public boolean create(JetbrainKey entity) {
        return repository.create(entity);
    }
    public boolean update(JetbrainKey entity) {
        return repository.update(entity);
    }
    public boolean delete(Integer id) {
        return repository.delete(id);
    }
}