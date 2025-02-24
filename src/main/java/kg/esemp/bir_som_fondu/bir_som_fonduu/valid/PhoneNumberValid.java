package kg.esemp.bir_som_fondu.bir_som_fonduu.valid;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import kg.esemp.bir_som_fondu.bir_som_fonduu.valid.impl.PhoneNumberValidator;

import java.lang.annotation.*;
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PhoneNumberValid {
    String message() default "Используйте код страны '+996', и длина номера телефона должна быть 13 символов";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
