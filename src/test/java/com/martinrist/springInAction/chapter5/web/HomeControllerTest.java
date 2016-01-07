package com.martinrist.springInAction.chapter5.web;

import com.martinrist.springInAction.chapter5.web.HomeController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class HomeControllerTest {

    private final HomeController controller = new HomeController();

    @Test
    public void testHomePageControllerAlwaysReturnsHomeViewName() {
        assertThat(controller.home(), is("home"));
    }

    @Test
    public void testHomePageAvailableAtRootUrl() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.view().name("home"));
    }

    @Test
    public void testHomePageAvailableAtAlternativeUrl() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/homepage"))
                .andExpect(MockMvcResultMatchers.view().name("home"));
    }
}
