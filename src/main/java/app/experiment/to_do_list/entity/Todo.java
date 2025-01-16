package app.experiment.to_do_list.entity;


import jakarta.persistence.*;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String task;
    private boolean completed;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    public long getId(){
        return id;
    }

    public String getTask(){
        return task;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setTask(String task){
        this.task = task;
    }

    public boolean isCompleted(){
        return completed;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }

    public Todo(String task,boolean completed){
        this.task = task;
        this.completed = completed;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Todo(){

    }
}
