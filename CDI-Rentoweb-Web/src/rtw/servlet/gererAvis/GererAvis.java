package rtw.servlet.gererAvis;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet principal de la fonctionnalité gererAvis
 * 
 * @author Aurélien
 * @version 1
 * @since 10/03/2017
 * 
 *  @see HttpServlet#HttpServlet()
 * 
 */
@WebServlet(
		
		name="GererAvis",
		
		urlPatterns = {
				
		"/gere-avis/*",
		
		
	})
public class GererAvis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Default constructor
     */
    public GererAvis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Redirection des demande GET de la fonctionnalité gérer avis.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String method = request.getMethod().toUpperCase();
		String pathInfo = request.getPathInfo();
		
		String info = "[" + method + "]" + " Path requested : " + pathInfo;
		
		System.out.println(info);
		
		
		
	}

	/**
	 * Redirection des demande POST de la fonctionnalité gérer avis.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String method = request.getMethod().toUpperCase();
		String pathInfo = request.getPathInfo();
		
		String info = "[" + method + "]" + " Path requested : " + pathInfo;
		
		System.out.println(info);
		
		
	}

}
