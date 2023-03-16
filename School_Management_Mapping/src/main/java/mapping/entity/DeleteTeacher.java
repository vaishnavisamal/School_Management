package mapping.entity;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Dell")
public class DeleteTeacher extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id=req.getParameter("Id");
		int id1=Integer.parseInt(id);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("samal");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Teacher t2=em.find(Teacher.class, id1);
		
		if(t2!=null) {
			et.begin();
			em.remove(t2);
			et.commit();
			
			RequestDispatcher rd=req.getRequestDispatcher("teachermenu.html");
			rd.include(req, resp);
			
			System.out.println("Teacher data removed from database");
		}
		else {
			System.out.println("Invalid Id.....!!!");
		}
		
		
	}
	

}
