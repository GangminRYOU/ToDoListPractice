package likelion.todolist.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import likelion.todolist.entity.ToDo;
import likelion.todolist.repository.ToDoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ToDoService {
	private final ToDoRepository toDoRepository;

	@Transactional
	public void saveToDo(String content){
		ToDo todo = new ToDo();
		todo.setContent(content);
		todo.setCompleted(false);
		toDoRepository.save(todo);
	}

	@Transactional
	public ToDo findOne(Long id){
		return toDoRepository.findOne(id);
	}

	@Transactional
	public List<ToDo> findToDos(){
		return toDoRepository.findAll();
	}

}
