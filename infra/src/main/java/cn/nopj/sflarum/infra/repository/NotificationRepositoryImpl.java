package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.Notification;
import cn.nopj.sflarum.domian.repository.NotificationRepository;
import cn.nopj.sflarum.infra.mapper.NotificationMapper;
import cn.nopj.sflarum.infra.po.NotificationPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class NotificationRepositoryImpl implements NotificationRepository {
    private final NotificationMapper mapper;
    @Override
    public Notification findById(Long id) {
        NotificationPo po = mapper.findById(id);
        if (po == null) {
            return null;
        }
        Notification entity = new Notification();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<Notification> findAll() {
        List<NotificationPo> list = mapper.findAll();
        List<Notification> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (NotificationPo po : list) {
            Notification entity = new Notification();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(Notification entity) {
        NotificationPo po = new NotificationPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(Notification entity) {
        NotificationPo po = new NotificationPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(Long id) {
        return mapper.deleteById(id) > 0;
    }
}