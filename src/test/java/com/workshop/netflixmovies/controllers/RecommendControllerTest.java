package com.workshop.netflixmovies.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.workshop.netflixmovies.model.entities.Title;
import com.workshop.netflixmovies.services.title.TitleService;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc(addFilters = false)
class RecommendControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TitleService titleService;

    Title title = new Title(1, "Star Wars 4", "2022", "9.9", "140",
            "Amazing movie made with love", 10.0f, 1000);

@BeforeEach
void setUp() {
when(titleService.recommendBestTitles(anyInt()))
.thenReturn((List.of(title)));
when(titleService.recommendBestTitlesByCategory(anyInt(), anyInt()))
.thenReturn((List.of(title)));}

    @Test
    void getBestRecommend() throws Exception {
        mockMvc.perform(get("/recommend/best?top=10")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print());
    }

    @Test
    void getBestRecommendByCategory() throws Exception {
        mockMvc.perform(get("/recommend/category/1?top=10")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}