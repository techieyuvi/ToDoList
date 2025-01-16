package app.experiment.to_do_list.model;

import app.experiment.to_do_list.entity.Priority;
import app.experiment.to_do_list.entity.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")

public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getAllTodos(){
        return todoService.getAllTodos();
    }

    @GetMapping("/completed")
    public ResponseEntity<List<Todo>> getByCompleted(){
        List<Todo> getbycompleted = todoService.findAllCompletedTrue();
        if( getbycompleted == null || getbycompleted.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(getbycompleted);
    }

    @GetMapping("/notcompleted")
    public ResponseEntity<List<Todo>> getByNot_Completed(){
        List<Todo> getbynot_completed = todoService.findAllCompletedFalse();
        if( getbynot_completed == null || getbynot_completed.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(getbynot_completed);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id){
        Optional<Todo> todo = todoService.getTodoById(id);
        return todo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{search}")
    public List<Todo> getAllTodosByTask(@RequestParam(required = false) String task, @RequestParam(required = false) Priority priority){
        if(task != null && priority != null){
            return todoService.getAllTodosByTask(task,priority);
        }
        return getAllTodos();
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
