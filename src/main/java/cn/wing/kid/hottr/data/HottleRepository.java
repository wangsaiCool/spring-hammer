package cn.wing.kid.hottr.data;

import cn.wing.kid.hottr.model.Hottle;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by WangSai on 2021/7/20
 */
@Component
public interface HottleRepository {

    List<Hottle> findHottles(long max, int count);

    Hottle findOne(long hottleId);
}
