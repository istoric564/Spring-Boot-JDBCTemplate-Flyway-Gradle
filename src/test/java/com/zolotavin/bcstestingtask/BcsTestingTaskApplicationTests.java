package com.zolotavin.bcstestingtask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureJdbc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;

@SpringBootTest
@AutoConfigureJdbc
@AutoConfigureMockMvc
class BcsTestingTaskApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void correctLoginTest() throws Exception {
//        this.mockMvc.perform(post("/register-likes"));
    }

}
