package com.martinrist.springInAction.chapter5.web;

import com.martinrist.springInAction.chapter5.data.SpitterRepository;
import com.martinrist.springInAction.chapter5.domain.Spitter;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpitterControllerTest {

    private SpitterRepository mockRepository;
    private MockMvc mockMvc;


    @Before
    public void setUp() {
        mockRepository = mock(SpitterRepository.class);
        SpitterController controller = new SpitterController(mockRepository);
        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void testShouldShowRegistration() throws Exception {
        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));
    }

    @Test
    public void testShouldProcessRegistration() throws Exception {

        Spitter unsaved = new Spitter("Jack", "Bauer", "jbauer", "24hours");
        Spitter saved = new Spitter(24L, "Jack", "Bauer", "jbauer", "24hours");

        when(mockRepository.save(unsaved)).thenReturn(saved);

        mockMvc.perform(post("/spitter/register")
                            .param("firstName", "Jack")
                            .param("lastName", "Bauer")
                            .param("username", "jbauer")
                            .param("password", "24hours"))
                .andExpect(redirectedUrl("/spitter/jbauer"));

        verify(mockRepository, atLeastOnce()).save(unsaved);

    }



}
