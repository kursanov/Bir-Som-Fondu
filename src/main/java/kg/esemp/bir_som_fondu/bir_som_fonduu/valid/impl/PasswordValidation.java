package kg.esemp.bir_som_fondu.bir_som_fonduu.valid.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import kg.esemp.bir_som_fondu.bir_som_fonduu.valid.PasswordValid;

public class PasswordValidation implements ConstraintValidator<PasswordValid, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) {
            return false; // Если пароль null — считаем его невалидным
        }

        return password.length() > 6 && containsUpperCase(password);
    }

    // Метод для проверки наличия хотя бы одной заглавной буквы в пароле
    private boolean containsUpperCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }
}

