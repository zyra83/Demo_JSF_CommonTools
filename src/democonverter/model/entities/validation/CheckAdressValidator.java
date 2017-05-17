package democonverter.model.entities.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Validatoeur d'adresse en suivant le tuto 
 * http://javabeat.net/bean-validation-java-ee-creating-custom-constraints-validations/
 * @author mickael
 *
 */
public class CheckAdressValidator implements ConstraintValidator<Normalized, String> {

	@Override
	public void initialize(Normalized constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value.trim().isEmpty() || value == null ) {
			return false;
		}
		
		if ( !value.contains("NORMALIZED") ) {
			return false;
		}

		return true;
	}

}
