package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.ApiKey;
import cn.nopj.sflarum.domian.repository.ApiKeyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ApiKeyService {
    private final ApiKeyRepository repository;
    public ApiKey findById(Long id) {
        return repository.findById(id);
    }
    public List<ApiKey> listAll() {
        return repository.findAll();
    }
    public boolean create(ApiKey entity) {
        return repository.create(entity);
    }
    public boolean update(ApiKey entity) {
        return repository.update(entity);
    }
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}