package com.example.demo.controller;

import com.example.demo.entity.TodoEntity;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public ResponseEntity home() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/todo")
    public List<TodoEntity> getAllTodo(@RequestParam(name = "name", required = false) String name) {
        return todoService.findByNameContains(name);
    }

    @PostMapping("/todo/add")
    public ResponseEntity addTodo(@RequestBody TodoEntity todoEntity) {
        return ResponseEntity.ok().body(todoService.addTodo(todoEntity));
    }

    @PutMapping("/todo/edit")
    public ResponseEntity editTodo(@RequestParam(name = "id") Long id,
                                   @RequestBody TodoEntity todoEntity) {
        return ResponseEntity.ok().body(todoService.editTodo(id, todoEntity));
    }

    @DeleteMapping("/todo/delete")
    public ResponseEntity<Boolean> deleteTodo(@RequestParam(name = "id") Long id) {
        return ResponseEntity.ok().body(todoService.deleteTodo(id));
    }
}
