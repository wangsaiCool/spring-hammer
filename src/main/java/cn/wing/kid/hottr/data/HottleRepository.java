package cn.wing.kid.hottr.data;

import java.util.List;

/**
 * Created by WangSai on 2021/7/20
 */
public interface HottleRepository {

    List<Hottle> findSpittles(long max, int count);
}
