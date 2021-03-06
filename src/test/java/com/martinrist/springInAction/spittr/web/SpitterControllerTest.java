package com.martinrist.springInAction.spittr.web;

import com.martinrist.springInAction.spittr.domain.Spitter;
import com.martinrist.springInAction.spittr.service.SpitterService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpitterControllerTest {

    private SpitterService mockService;
    private MockMvc mockMvc;


    @Before
    public void setUp() {
        mockService = mock(SpitterService.class);
        SpitterController controller = new SpitterController(mockService);
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

        MockMultipartFile mockPic = getMockProfilePic();

        mockMvc.perform(fileUpload("/spitter/register")
                        .file(mockPic)
                        .param("firstName", "Jack")
                        .param("lastName", "Bauer")
                        .param("username", "jbauer")
                        .param("password", "24hours"))
                .andExpect(redirectedUrl("/spittr/spitter/jbauer"));

        verify(mockService, atLeastOnce()).saveSpitter(unsaved);
        verify(mockPic, atLeastOnce()).transferTo(any());

    }

    @Test
    public void testEmptyRegistrationFormShouldReturnOriginalPage() throws Exception {

        MockMultipartFile mockPic = getMockProfilePic();

        mockMvc.perform(fileUpload("/spitter/register")
                        .file(mockPic))
                .andExpect(view().name("registerForm"))
                .andExpect(model().attributeHasFieldErrors("spitter", "firstName", "lastName", "username", "password"));

        verifyZeroInteractions(mockService);

        verify(mockPic, never()).transferTo(any());
    }



    @Test
    public void testRetrieveNonExistentSpitterShouldReturn404() throws Exception {

        mockMvc.perform(get("/spitter/thisisnottheuseryourelookingfor"))
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Helper method to get a 'mock' instance of MockMultipartFile that
     * always returns 'profilePicture' for its name.  This mock prevents
     * unit tests attempting to write to the filesystem when transferTo()
     * is called.
     */
    private MockMultipartFile getMockProfilePic() {
        MockMultipartFile mockPic = mock(MockMultipartFile.class);
        when(mockPic.getName()).thenReturn("profilePicture");
        return mockPic;
    }

}
