package emp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Data
@Component
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
		int id;
	String name;
	long mobile;
	String email;
	String password;

}
