package validators;

import java.util.regex.Pattern;

public class MailValidators {



	    // Définir une expression régulière pour valider les adresses e-mail
	    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

	    // Compiler l'expression régulière pour une utilisation plus efficace
	    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

	    // Méthode pour valider une adresse e-mail
	    public static boolean isValid(String email) {
	        if (email == null) {
	            return false;
	        }
	        // Matcher l'email avec le pattern
	        return EMAIL_PATTERN.matcher(email).matches();
	    }
	}

