package app.experiment.to_do_list.repository;

import app.experiment.to_do_list.entity.Priority;
import app.experiment.to_do_list.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByTask(String task);

    List<Todo> findByTaskAndCompleted(String task, boolean completed);

    List<Todo> findByCompleted(boolean completed);

    List<Todo> findAllByCompletedTrue();

    List<Todo> findAllByCompletedFalse();

    List<Todo> findByTaskContainingAndPriority(String task, Priority priority);
}
