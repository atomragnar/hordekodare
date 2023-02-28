
package org.hordekodning.alltid.hordekodare.web;

import org.hordekodning.alltid.hordekodare.Service.LinkService;
import org.hordekodning.alltid.hordekodare.Service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserPageController {

    @Autowired
    TodoServiceImpl todoService;

    @Autowired
    LinkService linkService;

    @GetMapping("/userpage")
    public String todoList(){
        return "userpage";
    }


    @PostMapping("/userpage") 
    public String postTodoList(@RequestParam String listItem, Model model){
        todoService.addToList(listItem);
        model.addAttribute("todos", todoService.getList());
        return "userpage";
    }

    @PostMapping("/updatelinks")
    public String addLink(Model model, @RequestParam String name, @RequestParam String url) {
        updateTodos(model);
        linkService.addList(name, url);
        model.addAttribute("links", linkService.getLinkList());
        return "userpage";
    }

    @PostMapping("/checkbox/{index}")
    public String checkbox (@PathVariable int index, @RequestParam(required = false) boolean isDone, Model model){
        updateLinks(model);
        todoService.getList().get(index).setDone(isDone);
        model.addAttribute("todos", todoService.getList());
        if (todoService.getList().get(index).isDone()){
            todoService.removeFromList(index);
    
        }
        return "userpage";
    }

    public void updateTodos(Model model) {
        model.addAttribute("todos", todoService.getList());
    }

    public void updateLinks(Model model) {
        model.addAttribute("links", linkService.getLinkList());
    }

}
