package cryss.dev.category_api.infraestructure.adapters.validation.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

@Documented
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.LOCAL_VARIABLE, METHOD, ElementType.TYPE })
@Constraint(validatedBy = GenericUniqueFieldValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueField {
    String message() default "The field name already in use.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
