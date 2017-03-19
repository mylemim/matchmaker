package com.mylemim.matchmaker.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mylemim.matchmaker.domain.Participant;
import com.mylemim.matchmaker.service.ParticipantRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Mile on 7.3.2017..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ParticipantControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    ParticipantRepository participantRepository;

    @Before
    public void setUp() {
        participantRepository.deleteAll();
    }


    @Test
    public void createParticipant() throws Exception {
        final String testName = "testName";

        RequestBuilder postBuilder = MockMvcRequestBuilders.post("/participants")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(new Participant(testName)));

        mvc.perform(postBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(testName)));
    }
}