package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.LoginProvider;
import cn.nopj.sflarum.domian.repository.LoginProviderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class LoginProviderService {
    private final LoginProviderRepository repository;
    public LoginProvider findById(Long id) {
        return repository.findById(id);
    }
    public List<LoginProvider> listAll() {
        return repository.findAll();
    }
    public boolean create(LoginProvider entity) {
        return repository.create(entity);
    }
    public boolean update(LoginProvider entity) {
        return repository.update(entity);
    }
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}