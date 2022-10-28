package com.workshop.netflixmovies.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.workshop.netflixmovies.controller.TitleController;
import com.workshop.netflixmovies.model.entities.Title;
import com.workshop.netflixmovies.services.title.TitleService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(TitleController.class)
@AutoConfigureMockMvc(addFilters = false)
public class TitleControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TitleService titleService;

    Title title = new Title(1, "Star Wars 4", "2022", "9.9", "140",
            "Amazing movie made with love", 10.0f, 1000);

    @BeforeEach
    void setupWineryService(){

    when(titleService.findAll()).thenReturn(List.of(title));
    when(titleService.findById(anyInt())).thenReturn(title);
    when(titleService.save(any(Title.class))).thenReturn(title);
    }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/title/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.*.id").isNotEmpty());
    }

    @Test
    public void findById() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("/title/{id}", 1).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Star Wars 4"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_rating").value(10.0));
    }

    // @Test
    // public void deleteTest() throws Exception {
    // mockMvc.perform(delete("/title/20").contentType(MediaType.APPLICATION_JSON))
    // .andExpect(status().isNoContent());
    // }

    public static String writeAsJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void createdTest() throws Exception {

        mockMvc.perform(post("/title/")
                .content(writeAsJsonString(title))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(notNullValue())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", is(equalTo(1))));

    }

    @Test
    public void updateTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .put("/title/1")
                .content(writeAsJsonString(title))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andDo(print());
    }

}
