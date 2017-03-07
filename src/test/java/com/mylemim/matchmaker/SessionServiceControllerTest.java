package com.mylemim.matchmaker;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mylemim.matchmaker.domain.Session;
import com.mylemim.matchmaker.service.SessionRepository;
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

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class SessionServiceControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    SessionRepository sessionRepository;

    @Before
    public void setUp() {
        sessionRepository.deleteAll();
    }

    @Test
    public void listSessions() throws Exception {
        final String testSessionName = "some";

        sessionRepository.save(new Session(testSessionName));

        mvc.perform(MockMvcRequestBuilders.get("/sessions").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(testSessionName)));
    }

    @Test
    public void createSession() throws Exception {
        final String testSessionName = "testName";

        RequestBuilder postBuilder = MockMvcRequestBuilders.post("/sessions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(new Session(testSessionName)));

        mvc.perform(postBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(testSessionName)));
    }
}