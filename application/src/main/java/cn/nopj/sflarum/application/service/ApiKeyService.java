package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.ApiKey;
import cn.nopj.sflarum.domian.repository.ApiKeyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ApiKeyService {
    private final ApiKeyRepository repository;
    private final SecureRandom secureRandom = new SecureRandom();
    public ApiKey findById(Long id) {
        return repository.findById(id);
    }
    public ApiKey findByKey(String key) {
        return repository.findByKey(key);
    }
    public List<ApiKey> listAll() {
        return repository.findAll();
    }
    public boolean create(ApiKey entity) {
        return repository.create(entity);
    }
    public ApiKey issueKey(Long userId, String scopes, String allowedIps) {
        ApiKey apiKey = new ApiKey();
        apiKey.setKey(generateToken(24));
        apiKey.setUserId(userId);
        apiKey.setScopes(scopes);
        apiKey.setAllowedIps(allowedIps);
        apiKey.setCreatedAt(LocalDateTime.now());
        apiKey.setLastActivityAt(LocalDateTime.now());
        repository.create(apiKey);
        return apiKey;
    }
    public boolean updateLastActivity(String key) {
        return repository.updateLastActivity(key, LocalDateTime.now());
    }
    public boolean update(ApiKey entity) {
        return repository.update(entity);
    }
    public boolean delete(Long id) {
        return repository.delete(id);
    }

    private String generateToken(int bytes) {
        byte[] buffer = new byte[bytes];
        secureRandom.nextBytes(buffer);
        StringBuilder sb = new StringBuilder(bytes * 2);
        for (byte b : buffer) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
