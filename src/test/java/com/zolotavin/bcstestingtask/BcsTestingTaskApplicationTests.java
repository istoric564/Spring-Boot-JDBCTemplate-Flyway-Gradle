package com.zolotavin.bcstestingtask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

//@Sql(value = {"/create-dishes-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//@Sql(value = {"/create-dishes-after.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@SpringBootTest
@AutoConfigureMockMvc
public class BcsTestingTaskApplicationTests extends Thread{

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCorrectInsert() throws Exception {

        String json = "{   \n" +
                "    \"listDishes\":\n" +
                "    [\n" +
                "    \"4223faa2-5f50-4c1d-904f-c71e88d08db7\",\n" +
                "    \"4223faa2-5f50-4c1d-904f-FFFFFFFFFFFF\",\n" +
                "    \"57e45856-ef73-49d9-bfad-f722f8717fae\",\n" +
                "    \"718d7dbd-e92e-40ef-b814-5a9844972762\",\n" +
                "    \"e5fa0c69-72c8-4558-a9c7-8dece1ecae55\",\n" +
                "    \"587a2d9c-836b-4bd5-a6f8-368da545a\",\n" +
                "    \"test\",\n" +
                "    \"587a2d9c-836b-4bd5-a6f8-368da545a\",\n" +
                "    \"test1\",\n" +
                "    \"587a2d9c-836b-4bd5-a6f8-368da5451\",\n" +
                "    \"test2\",\n" +
                "    \"587a2d9c-836b-4bd5-a6f8-368da5452\",\n" +
                "    \"test3\",\n" +
                "    \"587a2d9c-836b-4bd5-a6f8-368da5453\",\n" +
                "    \"test4\"\n" +
                "    ]\n" +
                "}";
        RequestBuilder request = MockMvcRequestBuilders
                .post("/register-likes")
                .accept(MediaType.APPLICATION_JSON)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }
}


