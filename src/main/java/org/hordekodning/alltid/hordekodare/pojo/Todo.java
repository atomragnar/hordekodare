package org.hordekodning.alltid.hordekodare.pojo;

public class Todo {
    private String todoObject;
    private boolean isDone;

    public Todo() {
    }

    public Todo(String todoObject){
        isDone = false;
        this.todoObject = todoObject;
    }

    public String getTodoObject() {
        return todoObject;
    }

    public void setTodoObject(String todoObject) {
        this.todoObject = todoObject;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
    @Override
    public String toString(){
        return todoObject;
    }
}
