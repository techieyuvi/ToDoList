package app.experiment.to_do_list.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Todo {

    @Id
    private long id;

    private String task;
    private boolean completed;

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

    public Todo(){

    }
}
