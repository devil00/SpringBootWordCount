package com.example.javainterview.controller;

import com.example.javainterview.model.WordRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Log4j2
class WordCounterControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testAddWord() throws Exception {
        mvc.perform(post("/add")
                .content(asJsonString(new WordRequest("hello hello world")))
                .contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isCreated());
    }

    @Test
    public void testGetWord() throws Exception {
        mvc.perform(get("/get-count/hello").contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(val -> log.info(val)).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.word").value("hello"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.count").value("2"));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}