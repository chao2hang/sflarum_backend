package cn.nopj.sflarum.application.service;
import cn.nopj.sflarum.domian.entity.AccessToken;
import cn.nopj.sflarum.domian.repository.AccessTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class AccessTokenService {
    private final AccessTokenRepository repository;
    private final SecureRandom secureRandom = new SecureRandom();
    public AccessToken findById(Long id) {
        return repository.findById(id);
    }
    public AccessToken findByToken(String token) {
        return repository.findByToken(token);
    }
    public List<AccessToken> listAll() {
        return repository.findAll();
    }
    public boolean create(AccessToken entity) {
        return repository.create(entity);
    }
    public AccessToken issueToken(Long userId, String type, String title, String ip, String userAgent) {
        AccessToken token = new AccessToken();
        token.setToken(generateToken(20));
        token.setUserId(userId);
        token.setCreatedAt(LocalDateTime.now());
        token.setLastActivityAt(LocalDateTime.now());
        token.setType(type == null || type.isBlank() ? "access" : type);
        token.setTitle(title);
        token.setLastIpAddress(ip);
        token.setLastUserAgent(userAgent);
        repository.create(token);
        return token;
    }
    public boolean updateLastActivity(String token, String ip, String userAgent) {
        return repository.updateLastActivity(token, LocalDateTime.now(), ip, userAgent);
    }
    public boolean update(AccessToken entity) {
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
