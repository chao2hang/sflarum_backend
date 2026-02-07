package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.LoginProvider;
import cn.nopj.sflarum.domian.repository.LoginProviderRepository;
import cn.nopj.sflarum.infra.mapper.LoginProviderMapper;
import cn.nopj.sflarum.infra.po.LoginProviderPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class LoginProviderRepositoryImpl implements LoginProviderRepository {
    private final LoginProviderMapper mapper;
    @Override
    public LoginProvider findById(Long id) {
        LoginProviderPo po = mapper.findById(id);
        if (po == null) {
            return null;
        }
        LoginProvider entity = new LoginProvider();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<LoginProvider> findAll() {
        List<LoginProviderPo> list = mapper.findAll();
        List<LoginProvider> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (LoginProviderPo po : list) {
            LoginProvider entity = new LoginProvider();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(LoginProvider entity) {
        LoginProviderPo po = new LoginProviderPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(LoginProvider entity) {
        LoginProviderPo po = new LoginProviderPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(Long id) {
        return mapper.deleteById(id) > 0;
    }
}