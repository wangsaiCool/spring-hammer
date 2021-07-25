package cn.wing.kid.hottr.data;

import cn.wing.kid.hottr.model.Hottle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangSai on 2021/7/23
 */
@Component(value = "hottleRepository")
public class HottleRepositoryImpl implements HottleRepository{
    @Override
    public List<Hottle> findHottles(long max, int count) {
        return new ArrayList<>();
    }

    @Override
    public Hottle findOne(long hottleId) {
        return null;
    }
}
