package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.ApiKey;
import cn.nopj.sflarum.domian.repository.ApiKeyRepository;
import cn.nopj.sflarum.infra.mapper.ApiKeyMapper;
import cn.nopj.sflarum.infra.po.ApiKeyPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class ApiKeyRepositoryImpl implements ApiKeyRepository {
    private final ApiKeyMapper mapper;
    @Override
    public ApiKey findById(Long id) {
        ApiKeyPo po = mapper.findById(id);
        if (po == null) {
            return null;
        }
        ApiKey entity = new ApiKey();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public ApiKey findByKey(String key) {
        ApiKeyPo po = mapper.findByKey(key);
        if (po == null) {
            return null;
        }
        ApiKey entity = new ApiKey();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<ApiKey> findAll() {
        List<ApiKeyPo> list = mapper.findAll();
        List<ApiKey> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (ApiKeyPo po : list) {
            ApiKey entity = new ApiKey();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(ApiKey entity) {
        ApiKeyPo po = new ApiKeyPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(ApiKey entity) {
        ApiKeyPo po = new ApiKeyPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean updateLastActivity(String key, java.time.LocalDateTime lastActivityAt) {
        return mapper.updateLastActivity(key, lastActivityAt) > 0;
    }
    @Override
    public boolean delete(Long id) {
        return mapper.deleteById(id) > 0;
    }
}
