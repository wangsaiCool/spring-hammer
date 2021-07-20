package cn.wing.kid.hottr.controller;

import cn.wing.kid.hottr.data.Hottle;
import cn.wing.kid.hottr.data.HottleRepository;
import org.hamcrest.core.IsCollectionContaining;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by WangSai on 2021/7/20
 */
public class HottleControllerTest {

    @Test
    public void showHottles() throws Exception {

        List<Hottle> expectedHottles = createHottlesList(20);
        HottleRepository mockRepository = Mockito.mock(HottleRepository.class);
        Mockito.when(mockRepository.findHottles(Long.MAX_VALUE, 20)).thenReturn(expectedHottles);

        HottleController controller = new HottleController(mockRepository);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB_INF/views/spittles.jsp")).build();

        // 调用MockMvc.perform(RequestBuilder requestBuilder)发起一个http请求，然后将得到ResultActions
        mockMvc.perform(MockMvcRequestBuilders.get("/hottles"))// 添加验证断言来判断执行请求后的结果是否是预期的；
                .andExpect(MockMvcResultMatchers.view().name("hottles"))// view()：得到视图验证器；
                // 得到相应的***ResultMatchers后，接着再调用其相应的API得到ResultMatcher，
                // 如ModelResultMatchers.attributeExists(final String... names)判断Model属性是否存在。
                .andExpect(MockMvcResultMatchers.model().attributeExists("hottleList"))// model()：得到模型验证器；
                .andExpect(MockMvcResultMatchers.model().attribute("hottleList", IsCollectionContaining.hasItems(expectedHottles.toArray())));


    }

    private List<Hottle> createHottlesList(int count) {
        List<Hottle> hottles = new ArrayList<Hottle>();
        for (int i = 0; i < count; i++) {
            hottles.add(new Hottle("Spittle " + i, new Date()));
        }
        return hottles;
    }
}