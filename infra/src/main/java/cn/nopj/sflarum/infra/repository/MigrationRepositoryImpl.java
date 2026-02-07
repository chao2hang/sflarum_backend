package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.Migration;
import cn.nopj.sflarum.domian.repository.MigrationRepository;
import cn.nopj.sflarum.infra.mapper.MigrationMapper;
import cn.nopj.sflarum.infra.po.MigrationPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class MigrationRepositoryImpl implements MigrationRepository {
    private final MigrationMapper mapper;
    @Override
    public Migration findById(Long id) {
        MigrationPo po = mapper.findById(id);
        if (po == null) {
            return null;
        }
        Migration entity = new Migration();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<Migration> findAll() {
        List<MigrationPo> list = mapper.findAll();
        List<Migration> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (MigrationPo po : list) {
            Migration entity = new Migration();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(Migration entity) {
        MigrationPo po = new MigrationPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(Migration entity) {
        MigrationPo po = new MigrationPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(Long id) {
        return mapper.deleteById(id) > 0;
    }
}