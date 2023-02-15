package emp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import emp.dto.Employee;
@Component
public class EmployeeDao {
EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
	

	public void signupEmployee(Employee emp)
	{
		transaction.begin();
		manager.persist(emp);
		transaction.commit();
		
	}
	public Employee login(String email)
	{
		List<Employee> list=manager.createQuery("Select x from Employee x where email=?1").setParameter(1, email).getResultList();
        if(list.isEmpty()) {
        	return null;
        } else {
        	return list.get(0);
        }
	
	}
	public List<Employee> fetchAll()
	{
		return manager.createQuery("Select x from Employee x").getResultList();
	}
}