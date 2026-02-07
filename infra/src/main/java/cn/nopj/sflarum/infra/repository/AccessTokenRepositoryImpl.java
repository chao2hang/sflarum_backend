package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.AccessToken;
import cn.nopj.sflarum.domian.repository.AccessTokenRepository;
import cn.nopj.sflarum.infra.mapper.AccessTokenMapper;
import cn.nopj.sflarum.infra.po.AccessTokenPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class AccessTokenRepositoryImpl implements AccessTokenRepository {
    private final AccessTokenMapper mapper;
    @Override
    public AccessToken findById(Long id) {
        AccessTokenPo po = mapper.findById(id);
        if (po == null) {
            return null;
        }
        AccessToken entity = new AccessToken();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public AccessToken findByToken(String token) {
        AccessTokenPo po = mapper.findByToken(token);
        if (po == null) {
            return null;
        }
        AccessToken entity = new AccessToken();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<AccessToken> findAll() {
        List<AccessTokenPo> list = mapper.findAll();
        List<AccessToken> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (AccessTokenPo po : list) {
            AccessToken entity = new AccessToken();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(AccessToken entity) {
        AccessTokenPo po = new AccessTokenPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(AccessToken entity) {
        AccessTokenPo po = new AccessTokenPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean updateLastActivity(String token, java.time.LocalDateTime lastActivityAt, String lastIpAddress, String lastUserAgent) {
        return mapper.updateLastActivity(token, lastActivityAt, lastIpAddress, lastUserAgent) > 0;
    }
    @Override
    public boolean delete(Long id) {
        return mapper.deleteById(id) > 0;
    }
}
