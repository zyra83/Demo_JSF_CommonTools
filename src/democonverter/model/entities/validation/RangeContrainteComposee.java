package democonverter.model.entities.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
/**
 * Ici on a choisi de faire une Contraine Bean validation composée
 * elle n'utilise pas le validateed by, c'est plus simple.
 * 
 * @author mickael
 *
 */
@NotNull
@Min(0)
@Max(100)
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = {})
@Documented
public @interface RangeContrainteComposee {
	// The message to return when the instance of MyAddress fails the
	// validation.
	String message() default "Adresse invalidée par BeanValidation @Normalized";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
