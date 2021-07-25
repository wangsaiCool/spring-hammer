package cn.wing.kid.hottr.controller;

import cn.wing.kid.hottr.data.HotterRepository;
import cn.wing.kid.hottr.model.Hotter;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by WangSai on 2021/7/21
 */
public class HotterControllerTest {

    @Test
    public void showRegistration() throws Exception {
        HotterRepository mockRepository = Mockito.mock(HotterRepository.class);
        HotterController hotterController = new HotterController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(hotterController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/hotter/register"))
                .andExpect(MockMvcResultMatchers.view().name("registerForm"));

    }

    /**
     * 测试这个case的时候，遇见了几个问题：https://www.cnblogs.com/mswangblog/p/6548146.html
     * @throws Exception
     */
    @Test
    public void shouldProcessRegistration() throws Exception {
        HotterRepository mockRepository = Mockito.mock(HotterRepository.class);
        Hotter unsaved = new Hotter("jbauer", "24hours", "Jack", "Bauer");
        Hotter saved = new Hotter(24L, "jbauer", "24hours", "Jack", "Bauer");

        Mockito.when(mockRepository.save(unsaved)).thenReturn(saved);

        HotterController controller = new HotterController(mockRepository);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/hotter/register")
                .param("firstName", "Jack")
                .param("lastName", "Bauer")
                .param("username", "jbauer")
                .param("password", "24hours"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/hotter/jbauer"));

        Mockito.verify(mockRepository, Mockito.atLeastOnce()).save(unsaved);
    }


}