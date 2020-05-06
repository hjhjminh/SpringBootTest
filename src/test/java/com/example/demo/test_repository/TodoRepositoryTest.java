package com.example.demo.test_repository;

import com.example.demo.entity.TodoEntity;
import com.example.demo.repository.TodoRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
//@SpringBootTest
public class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

//    @Before
//    public void initRepo() {
////        TodoEntity todo1 = new TodoEntity("Code", "Spring Boot Test");
////        todoRepository.save(todo1);
//        System.out.println(todoRepository.findAll());
//    }

    @Test
    public void testRepo() {
        System.out.println(todoRepository.findAll().size());
        System.out.println(todoRepository.findAll());
        Assert.assertTrue(todoRepository.findAll().size() == 4);
    }

}
