package cn.wing.kid.hottr.data;

import cn.wing.kid.hottr.model.Hotter;
import org.springframework.stereotype.Component;

/**
 * Created by WangSai on 2021/7/25
 */
@Component
public interface HotterRepository {
    Hotter save(Hotter hotter);

    Hotter findByUsername(String username);

}
