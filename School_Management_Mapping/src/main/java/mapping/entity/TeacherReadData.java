package mapping.entity;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/dataTeacher")
public class TeacherReadData extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("samal");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Query q=em.createQuery("select b from Teacher b");
		List<Teacher> teacher=q.getResultList();
		
		for(Teacher s:teacher) {
			System.out.println(s.getId());
			System.out.println(s.getName());
			System.out.println(s.getSubject());
			System.out.println(s.getSalary());
		}
	}
	

}
