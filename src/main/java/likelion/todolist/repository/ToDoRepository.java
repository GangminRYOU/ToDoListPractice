package likelion.todolist.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import likelion.todolist.entity.ToDo;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ToDoRepository {
	//엔티티 관리해주는 엔티티 매니저
	private final EntityManager em;

	//데이터를 저장한다.
	public void save(ToDo todo){
		if(todo.getId() == null){
			em.persist(todo);
		}else{
			em.merge(todo);
		}
	}

	//삭제코드 추가
	public void delete(ToDo todo){
		em.remove(todo);
	}

	//데이터를 id로 하나만 조회한다.
	public ToDo findOne(Long id){
		return em.find(ToDo.class, id);
	}

	//저장된 모든 데이터를 조회한다.
	public List<ToDo> findAll(){
		return em.createQuery("select i from ToDo i", ToDo.class)
			.getResultList();
	}
}
