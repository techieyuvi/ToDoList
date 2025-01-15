package app.experiment.to_do_list.repository;

import app.experiment.to_do_list.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByTask(String task);

    List<Todo> findByTaskAndCompleted(String task, boolean completed);

    List<Todo> findByCompleted(boolean completed);

}
