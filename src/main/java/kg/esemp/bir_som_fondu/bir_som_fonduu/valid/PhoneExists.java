package kg.esemp.bir_som_fondu.bir_som_fonduu.valid;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import kg.esemp.bir_som_fondu.bir_som_fonduu.valid.impl.PhoneExistsValidator;

import java.lang.annotation.*;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneExistsValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneExists {
    String message() default "Пользователь с таким номером телефона не найден!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
