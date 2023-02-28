package org.hordekodning.alltid.hordekodare.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TodoController {

    @Autowired
    TodoServiceImpl todoService;

    @GetMapping("/userpage")
    public String todoList(){
        return "userpage";
    }


    @PostMapping("/userpage")
    public String postTodoList(@RequestParam String listItem, Model model){
        todoService.addToList(listItem);
        model.addAttribute("list", todoService.getList());
        return "userpage";
    }

    @PostMapping("/checkbox/{index}")
    public String checkbox (@PathVariable int index, @RequestParam(required = false) boolean isDone, Model model){
        todoService.getList().get(index).setDone(isDone);
        model.addAttribute("list", todoService.getList());
        if (todoService.getList().get(index).isDone()){
            todoService.removeFromList(index);
        }
        return "userpage";
    }

}
