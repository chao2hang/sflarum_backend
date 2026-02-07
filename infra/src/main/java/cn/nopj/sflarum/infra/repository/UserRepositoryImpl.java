package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.User;
import cn.nopj.sflarum.domian.repository.UserRepository;
import cn.nopj.sflarum.infra.mapper.UserMapper;
import cn.nopj.sflarum.infra.po.UserPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private final UserMapper mapper;
    @Override
    public User findById(Long id) {
        UserPo po = mapper.findById(id);
        if (po == null) {
            return null;
        }

        User entity = new User();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<User> findAll() {
        List<UserPo> list = mapper.findAll();
        List<User> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (UserPo po : list) {
            User entity = new User();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(User entity) {
        UserPo po = new UserPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(User entity) {
        UserPo po = new UserPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(Long id) {
        return mapper.deleteById(id) > 0;
    }
}