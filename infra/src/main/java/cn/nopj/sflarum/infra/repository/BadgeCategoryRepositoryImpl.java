package cn.nopj.sflarum.infra.repository;
import cn.nopj.sflarum.domian.entity.BadgeCategory;
import cn.nopj.sflarum.domian.repository.BadgeCategoryRepository;
import cn.nopj.sflarum.infra.mapper.BadgeCategoryMapper;
import cn.nopj.sflarum.infra.po.BadgeCategoryPo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor
public class BadgeCategoryRepositoryImpl implements BadgeCategoryRepository {
    private final BadgeCategoryMapper mapper;
    @Override
    public BadgeCategory findById(Long id) {
        BadgeCategoryPo po = mapper.findById(id);
        if (po == null) {
            return null;
        }
        BadgeCategory entity = new BadgeCategory();
        BeanUtils.copyProperties(po, entity);
        return entity;
    }
    @Override
    public List<BadgeCategory> findAll() {
        List<BadgeCategoryPo> list = mapper.findAll();
        List<BadgeCategory> result = new ArrayList<>();
        if (list == null) {
            return result;
        }
        for (BadgeCategoryPo po : list) {
            BadgeCategory entity = new BadgeCategory();
            BeanUtils.copyProperties(po, entity);
            result.add(entity);
        }
        return result;
    }
    @Override
    public boolean create(BadgeCategory entity) {
        BadgeCategoryPo po = new BadgeCategoryPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.insert(po) > 0;
    }
    @Override
    public boolean update(BadgeCategory entity) {
        BadgeCategoryPo po = new BadgeCategoryPo();
        BeanUtils.copyProperties(entity, po);
        return mapper.update(po) > 0;
    }
    @Override
    public boolean delete(Long id) {
        return mapper.deleteById(id) > 0;
    }
}