package cn.nopj.sflarum.domian.repository;
import cn.nopj.sflarum.domian.entity.EmailToken;
import java.util.List;
public interface EmailTokenRepository {
    EmailToken findById(String id);
    List<EmailToken> findAll();
    boolean create(EmailToken entity);
    boolean update(EmailToken entity);
    boolean delete(String id);
}