package cn.wing.kid.hottr.data;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by WangSai on 2021/7/20
 */
@Component
public interface HottleRepository {

    List<Hottle> findHottles(long max, int count);
}
