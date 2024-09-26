package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
/**
 * Servlet implementation class Servlet1
 */

@WebServlet(
	    urlPatterns = {"/Servlet1"},
	    initParams = {
	        @WebInitParam(name = "course", value = "Jakarta EE"),
	        @WebInitParam(name = "author", value = "hadil")
	    }
	)
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   private String cours;
	    private String auteur;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
        // Initialisation des attributs à partir des paramètres d'initialisation
        cours = config.getInitParameter("course");
        auteur = config.getInitParameter("author");
    		}
    	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  // Préparer la réponse de type HTML
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        // Récupérer les informations demandées
        String requestURL = request.getRequestURL().toString();
        String clientIP = request.getRemoteAddr();
        String acceptedLanguages = request.getHeader("Accept-Language");

        // Récupérer toutes les en-têtes HTTP
        Enumeration<String> headerNames = request.getHeaderNames();
        
        
        // Construire la réponse HTML
        StringBuilder htmlResponse = new StringBuilder();
        htmlResponse.append("<html><body>");
        htmlResponse.append("<h1>Bienvenue dans le cours Servlet</h1>");
        htmlResponse.append("<p>Course : ").append(cours).append("</p>");
        htmlResponse.append("<p>Auteur : ").append(auteur).append("</p>");
        htmlResponse.append("<p>URL de la requête : ").append(requestURL).append("</p>");
        htmlResponse.append("<p>Adresse IP du client : ").append(clientIP).append("</p>");
        htmlResponse.append("<p>Langues acceptées par le client : ").append(acceptedLanguages).append("</p>");

        
        // Afficher toutes les en-têtes HTTP
        htmlResponse.append("<h2>En-têtes HTTP de la requête</h2>");
        htmlResponse.append("<ul>");
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            htmlResponse.append("<li>").append(headerName).append(": ").append(headerValue).append("</li>");
        }
        htmlResponse.append("</ul>");

        htmlResponse.append("</body></html>");

        // Envoyer la réponse HTML au client
        response.getWriter().write(htmlResponse.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
