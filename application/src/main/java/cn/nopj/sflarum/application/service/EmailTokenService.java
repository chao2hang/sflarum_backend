package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.EmailToken;
import cn.nopj.sflarum.domian.repository.EmailTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class EmailTokenService {
    private final EmailTokenRepository repository;
    public EmailToken findById(String id) {
        return repository.findById(id);
    }
    public List<EmailToken> listAll() {
        return repository.findAll();
    }
    public boolean create(EmailToken entity) {
        return repository.create(entity);
    }
    public boolean update(EmailToken entity) {
        return repository.update(entity);
    }
    public boolean delete(String id) {
        return repository.delete(id);
    }
}