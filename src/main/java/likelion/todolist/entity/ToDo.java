package likelion.todolist.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//엔티티 클래스 : MySQL의 테이블과 매핑되는 엔티티 객체를 정의하는 클래스이다.
@Entity
@Getter
@Setter
public class ToDo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 200)
	private String content;

	@Column(nullable = false)
	private Boolean completed;
}
