package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.AccessToken;
import cn.nopj.sflarum.domian.repository.AccessTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class AccessTokenService {
    private final AccessTokenRepository repository;
    public AccessToken findById(Long id) {
        return repository.findById(id);
    }
    public List<AccessToken> listAll() {
        return repository.findAll();
    }
    public boolean create(AccessToken entity) {
        return repository.create(entity);
    }
    public boolean update(AccessToken entity) {
        return repository.update(entity);
    }
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}