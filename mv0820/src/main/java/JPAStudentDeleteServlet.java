

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.persistence.*;
import model.*;
import java.util.*;
/**
 * Servlet implementation class JPAStudentDeleteServlet
 */
@WebServlet("/JPAStudentDeleteServlet")
public class JPAStudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JPAStudentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("mv0820");
	        EntityManager em = emf.createEntityManager();

	        em.getTransaction().begin();
	        
            Student obj=em.find(Student.class, 1001);
	        System.out.println(obj);
            em.remove(obj);
	        
            em.getTransaction().commit();
	        em.close();
	        emf.close();
	        request.getRequestDispatcher("JPAStudentServlet").forward(request, response);
	       
			}catch(Exception ex) {
				 response.getWriter().append("Error:"+ex.getMessage());
			}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
