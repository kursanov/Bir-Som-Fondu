package kg.esemp.bir_som_fondu.bir_som_fonduu.valid.impl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import kg.esemp.bir_som_fondu.bir_som_fonduu.valid.PhoneExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import kg.esemp.bir_som_fondu.bir_som_fonduu.repository.UserRepository;

@Component
public class PhoneExistsValidator implements ConstraintValidator<PhoneExists, String> {

    private final UserRepository userRepository;

    @Autowired
    public PhoneExistsValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {
        return userRepository.existsByPhone(phone);  // Метод в репозитории, проверяющий номер в базе
    }
}
