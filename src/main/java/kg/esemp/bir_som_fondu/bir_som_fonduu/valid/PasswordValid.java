package kg.esemp.bir_som_fondu.bir_som_fonduu.valid;

import com.auth0.jwt.interfaces.Payload;
import jakarta.validation.Constraint;
import kg.esemp.bir_som_fondu.bir_som_fonduu.valid.impl.PasswordValidation;

import java.lang.annotation.*;

@Constraint(validatedBy = PasswordValidation.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PasswordValid {


    String message() default "Пароль должен содержать хотя бы одну заглавную букву и быть длиннее шести символов";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
