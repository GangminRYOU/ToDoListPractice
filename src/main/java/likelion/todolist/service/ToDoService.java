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
	public void deleteToDo(Long id){
		ToDo findToDo = toDoRepository.findOne(id);
		if(findToDo == null){
			throw new IllegalArgumentException("해당 아이템이 없습니다.");
		}
		toDoRepository.delete(findToDo);
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
