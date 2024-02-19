package com.example.todoapp.controller;

import com.example.todoapp.domain.ToDo;
import com.example.todoapp.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor //스프링이 실행하면서 자동으로 데이터를 넣어준다.
public class TodoController {
    private final ToDoRepository toDoRepository;
    @GetMapping("/")
    public String index(Model model)
    {
        List<ToDo> todos = toDoRepository.findAll();
        model.addAttribute("todos", todos);
        return "todos";

    }

    @PostMapping("addTodo")
    public String addTodo(@RequestParam("todo") String todo){
        ToDo toDo = new ToDo();
        toDo.setTodo(todo);
        toDoRepository.save(toDo);
        return "redirect:/"; // /으로 자동 이동해라
    }
}
