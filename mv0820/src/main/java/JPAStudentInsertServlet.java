

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
 * Servlet implementation class JPAStudentInsertServlet
 */
@WebServlet("/JPAStudentInsertServlet")
public class JPAStudentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JPAStudentInsertServlet() {
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

        Student s1 = new Student();
        s1.setId(1001);
        s1.setUsername("Max");
        s1.setAge(27);

        Student s2 = new Student();
        s2.setId(1002);
        s2.setUsername("Yen");
        s2.setAge(21);       

        em.persist(s1);
        em.persist(s2);       

        em.getTransaction().commit();
        em.close();
        emf.close();
       // response.getWriter().append("See DB Student Data");
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
