package likelion.todolist.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import likelion.todolist.entity.ToDo;
import likelion.todolist.service.ToDoService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ToDoController {
	private final ToDoService toDoService;

	@GetMapping("/todo")
	public String helloController(Model model){
		List<ToDo> toDoList = toDoService.findToDos();
		model.addAttribute("toDoList", toDoList);
		return "todolist";
	}

	@GetMapping("/")
	public String root(){
		return "redirect:/todo";
	}
	@PostMapping("/todo/create")
	public String todoCreate(@RequestParam String content){
		toDoService.saveToDo(content);
		return "redirect:/todo";
	}

}
