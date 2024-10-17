package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import validators.MailValidators;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/ServletRegistration")  // URL Mapping
public class ServletRegistration extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handle GET requests to display the registration form
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to the registration form JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registration.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the form fields
        String firstName = request.getParameter("firstName");
        String familyName = request.getParameter("familyName");
        String email = request.getParameter("email");

        // HashMap to store errors with field IDs
        Map<String, String> errors = new HashMap<>();

        // Validate input fields
        if (firstName == null || firstName.trim().isEmpty()) {
            errors.put("firstNameError", "First Name is required.");
        }

        if (familyName == null || familyName.isBlank()) {
            errors.put("familyNameError", "Family Name is required.");
        }

        if (email == null || email.trim().isEmpty()) {
            errors.put("emailError", "Email is required.");
        } else if (!MailValidators.isValid(email)) {  
            errors.put("emailError", "Invalid email format.");
        }

        if (!errors.isEmpty()) {
            // Forward back to form with errors
            request.setAttribute("errors", errors);
            request.setAttribute("firstName", firstName);
            request.setAttribute("familyName", familyName);
            request.setAttribute("email", email);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registration.jsp");
            dispatcher.forward(request, response);
        } else {
            // Redirect to the success page
            request.setAttribute("firstName", firstName);
            request.setAttribute("familyName", familyName);
            request.setAttribute("email", email);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/SuccessRegistration.jsp");
            dispatcher.forward(request, response);
        }
    }
}
