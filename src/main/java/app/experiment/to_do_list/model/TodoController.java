package app.experiment.to_do_list.model;

import app.experiment.to_do_list.entity.Todo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")

public class TodoController {

    private TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id){
        Optional<Todo> todo = todoService.getTodoById(id);
        return todo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Todo> CreateTodo(@RequestBody Todo todo){
        Todo createdTodo =todoService.addTodo(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateToDo(@PathVariable Long id,Todo todo){
        Todo updateTodo = todoService.updateTodo(id,todo );
        if(updateTodo != null){
          return ResponseEntity.ok(updateTodo);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Todo> deleteToDo( Long id,Todo todo){
        todoService.deleteTodo(id);
        return  ResponseEntity.noContent().build();
    }











}
