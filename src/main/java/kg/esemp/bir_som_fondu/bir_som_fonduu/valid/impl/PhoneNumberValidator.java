package kg.esemp.bir_som_fondu.bir_som_fonduu.valid.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import kg.esemp.bir_som_fondu.bir_som_fonduu.valid.PhoneNumberValid;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberValid,String> {
    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        return phoneNumber.startsWith("+996") && phoneNumber.length()==13;
    }
}