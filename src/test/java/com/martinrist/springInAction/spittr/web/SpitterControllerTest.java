package com.martinrist.springInAction.spittr.web;

import com.martinrist.springInAction.spittr.data.SpitterRepository;
import com.martinrist.springInAction.spittr.domain.Spitter;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
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

        // TODO: Replace this with a proper mock object that doesn't get written to the filesystem
        MockMultipartFile profilePic = new MockMultipartFile("profilePicture",
                "foo.txt",
                "text/plain",
                new byte[] {});

        mockMvc.perform(fileUpload("/spitter/register")
                        .file(profilePic)
                        .param("firstName", "Jack")
                        .param("lastName", "Bauer")
                        .param("username", "jbauer")
                        .param("password", "24hours"))
                .andExpect(redirectedUrl("/spittr/spitter/jbauer"));

        verify(mockRepository, atLeastOnce()).save(unsaved);

    }

    @Test
    public void testEmptyRegistrationFormShouldReturnOriginalPage() throws Exception {

        // TODO: Replace this with a proper mock object that doesn't get written to the filesystem
        MockMultipartFile profilePic = new MockMultipartFile("profilePicture",
                "foo.txt",
                "text/plain",
                new byte[] {});

        mockMvc.perform(fileUpload("/spitter/register")
                        .file(profilePic))
                .andExpect(view().name("registerForm"))
                .andExpect(model().attributeHasFieldErrors("spitter", "firstName", "lastName", "username", "password"));

        verifyZeroInteractions(mockRepository);
    }



    @Test
    public void testRetrieveNonExistentSpitterShouldReturn404() throws Exception {

        mockMvc.perform(get("/spitter/thisisnottheuseryourelookingfor"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

}
