package cryss.dev.category_api.infraestructure.adapters.validation.constraints.annotations;

import cryss.dev.category_api.infraestructure.adapters.validation.constraints.validators.GenericUniqueFieldValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER })
@Constraint(validatedBy = GenericUniqueFieldValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueFieldName {
    String message() default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
