package democonverter.model.entities.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = CheckAdressValidator.class)
@Documented
public @interface Normalized {
	// The message to return when the instance of MyAddress fails the
	// validation.
	String message() default "Adresse invalidée par BeanValidation @Normalized";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
