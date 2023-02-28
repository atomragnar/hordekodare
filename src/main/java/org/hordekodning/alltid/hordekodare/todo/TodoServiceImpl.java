package org.hordekodning.alltid.hordekodare.todo;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope
public class TodoServiceImpl{
    private List<Todo> todoList;

    public TodoServiceImpl() {
        todoList = new ArrayList<>();
    }

    public void addToList (String todoMess){
        todoList.add(new Todo(todoMess));

    }
    public void removeFromList (int index){
        todoList.remove(index);
    }
    public List<Todo> getList(){
    return todoList;
    }




}
