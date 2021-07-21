package cn.wing.kid.hottr.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by WangSai on 2021/7/21
 */
public class HottlerControllerTest {

    @Test
    public void showRegistration() throws Exception {
        HottlerController hottlerController = new HottlerController();
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(hottlerController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/hotter/register"))
                .andExpect(MockMvcResultMatchers.view().name("registerForm"));

    }

}