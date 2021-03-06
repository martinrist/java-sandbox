package com.martinrist.springInAction.spittr.web;

import com.martinrist.springInAction.spittr.domain.Spittle;
import com.martinrist.springInAction.spittr.service.SpitterService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpittleControllerTest {

    private SpitterService mockService;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockService = mock(SpitterService.class);
        SpittleController controller = new SpittleController(mockService);
        mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();
    }

    @Test
    public void testShouldShowRecentSpittles() throws Exception {

        List<Spittle> expectedSpittles = createSpittleList(20);

        when(mockService.getRecentSpittles(20)).thenReturn(expectedSpittles);

        mockMvc.perform(get("/spittles"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));

    }

    @Test
    public void testShouldShowPagedSpittles() throws Exception {

        List<Spittle> expectedSpittles = createSpittleList(50);

        when(mockService.getRecentSpittles(50)).thenReturn(expectedSpittles);

        mockMvc.perform(get("/spittles?max=238900&count=50"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));

    }

    @Test
    public void testShouldShowIndividualSpittle() throws Exception {

        Spittle expectedSpittle = new Spittle("Hello", new Date());

        when(mockService.getSpittleById(12345)).thenReturn(expectedSpittle);

        mockMvc.perform(get("/spittles/12345"))
                .andExpect(view().name("spittle"))
                .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle", expectedSpittle));

    }

    private List<Spittle> createSpittleList(int count) {
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }

        return spittles;
    }
}
