package com.example.demo.test_controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.controller.TodoController;
import com.example.demo.entity.TodoEntity;
import com.example.demo.repository.TodoRepository;
import com.example.demo.service.TodoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
//@WebMvcTest(TodoController.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @MockBean
//    @Autowired
//    private TodoService todoService;

//    @Before
//    public void mockService() {
//        TodoEntity todo1 = new TodoEntity("Code", "Spring Boot Test");
//        List<TodoEntity> listTodo = Arrays.asList(todo1);
//        Mockito.when(todoService.findByNameContains("")).thenReturn(listTodo);
//    }

    @Test
    public void testApi() throws Exception {
//        TodoEntity todo1 = new TodoEntity("Code", "Spring");
//        TodoEntity todo1 = todoRepository.getOne((long) 1);
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        String json = ow.writeValueAsString(todo1);

//        mockMvc.perform(post("/api/v1/todo/add")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(json)).andExpect(status().isOk());
//
//        mockMvc.perform(put("/api/v1/todo/edit")
//                .contentType(MediaType.APPLICATION_JSON)
//                .param("id", "10")
//                .content(json))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").isNumber());

        mockMvc.perform(get("/api/v1/todo")
                .param("name", "")
                .contentType(MediaType.APPLICATION_JSON)
                .header("X-AUTH", "SOME TOKEN"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].name", is("Code123")));
    }
}
