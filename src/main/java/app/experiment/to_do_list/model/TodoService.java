package app.experiment.to_do_list.model;


import app.experiment.to_do_list.entity.Todo;
import app.experiment.to_do_list.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Long id){
        return todoRepository.findById(id);
    }

    public Todo addTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id,Todo todo){
        if(todoRepository.existsById(id)){
            todo.setId(id);
            return todoRepository.save(todo);
        }
        return null;
    }

    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }
}
