package com.selectbr.github.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.selectbr.github.config.GithubExceptionHandlerConfig;
import com.selectbr.github.dtos.GithubDTO;
import com.selectbr.github.service.GithubService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class GithubControllerTest {

    @Mock
    private GithubService service;

    @InjectMocks
    private GithubController githubController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(githubController)
                .setControllerAdvice(new GithubExceptionHandlerConfig())
                .build();
    }

    @ParameterizedTest
    @CsvSource({"test", "test1"})
    void getRepositoriesByUser_success(String username) throws Exception {
        //given
        var githubDto = new GithubDTO("test", "test description", "http://test.com", LocalDateTime.now());
        List<GithubDTO> githubDtoList = Arrays.asList(githubDto);

        Mockito.when(service.getRepositoriesByUser(username)).thenReturn(githubDtoList);

        //when
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/github/{username}", username))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        String response = mvcResult.getResponse().getContentAsString();
        var githubResponse = objectMapper.readValue(response, new TypeReference<List<GithubDTO>>() {
        });


        // Then
        assertEquals(githubDtoList, githubResponse);
        Mockito.verify(service).getRepositoriesByUser(username);

    }
}