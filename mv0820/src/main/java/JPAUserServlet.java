

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import java.util.*;
/**
 * Servlet implementation class JPAUserServlet
 */
@WebServlet("/JPAUserServlet")
public class JPAUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JPAUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mv0820");
	     EntityManager entityManager = entityManagerFactory.createEntityManager();
	     entityManager.getTransaction().begin();
	        String data="";
	        List<User> result = entityManager.createNamedQuery("User.findAll").getResultList();
	       // List<User> result = entityManager.createQuery("select u " + "from User u ").getResultList();
	        for (User user : result) {
	            System.out.println(user.getName());
	            data+="User ID:"+user.getId()+" User Name:"+user.getName()+"\n";
	        }	        
	        entityManager.getTransaction().commit();
	        entityManager.close();
	        request.setAttribute("users", result);
	        request.getRequestDispatcher("user.jsp").forward(request, response);
            //response.getWriter().append(data);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
