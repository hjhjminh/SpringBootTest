package com.example.demo.service;

import com.example.demo.entity.TodoEntity;
import com.example.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<TodoEntity> findAll() {
        return todoRepository.findAll();
    }

    public List<TodoEntity> findByNameContains(String name) {
        if (StringUtils.isEmpty(name)) {
            return todoRepository.findAll();
        } else {
            return todoRepository.findByNameContains(name);
        }
    }

    public TodoEntity addTodo(TodoEntity todoEntity) {
        return todoRepository.save(todoEntity);
    }

    public TodoEntity editTodo(Long id, TodoEntity todoEntity) {
        Optional<TodoEntity> todoEdit = todoRepository.findById(id);
        if (todoEdit.isEmpty()) {
            return null;
        } else {
            todoEntity.setId(todoEdit.get().getId());
            return todoRepository.save(todoEntity);
        }
    }

    public boolean deleteTodo(Long id) {
        Optional<TodoEntity> todoEntity = todoRepository.findById(id);
        if (todoEntity.isEmpty()) {
            return false;
        } else {
            todoRepository.deleteById(id);
            return true;
        }
    }
}
