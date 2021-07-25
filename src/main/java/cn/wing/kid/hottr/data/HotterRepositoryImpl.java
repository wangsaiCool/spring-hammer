package cn.wing.kid.hottr.data;

import cn.wing.kid.hottr.model.Hotter;
import org.springframework.stereotype.Component;

/**
 * Created by WangSai on 2021/7/25
 */
@Component(value = "hotterRepository")
public class HotterRepositoryImpl implements HotterRepository {
    @Override
    public Hotter save(Hotter hotter) {
        return new Hotter("firstName2", "lastName2", "username2", "password2");

    }

    @Override
    public Hotter findByUsername(String username) {
        return new Hotter("firstName1", "lastName1", "username1", "password1");
    }

}
