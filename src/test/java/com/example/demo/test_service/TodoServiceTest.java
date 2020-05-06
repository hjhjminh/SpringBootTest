package com.example.demo.test_service;

import com.example.demo.entity.TodoEntity;
import com.example.demo.repository.TodoRepository;
import com.example.demo.service.TodoService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoServiceTest {

//    @TestConfiguration
//    static class Configuration {
//
//        @Bean
//        TodoService todoService() {
//            return new TodoService();
//        }
//    }

    @Autowired
    private TodoService todoService;

//    @MockBean
//    private TodoRepository todoRepository;

//    @Before
//    public void initRepo() {
//        TodoEntity todo1 = new TodoEntity((long) 1, "Code", "Spring Boot Test");
//        List<TodoEntity> listTodo = Arrays.asList(todo1);
//
//        Mockito.when(todoRepository.findAll()).thenReturn(listTodo);
//    }

    @Test
    public void testService() {
//        Assert.assertTrue(todoService.findAll().size() == 3);
        System.out.println(todoService.findAll());
    }
}
