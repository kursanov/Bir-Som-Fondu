package kg.esemp.bir_som_fondu.bir_som_fonduu.config.request;

import jakarta.validation.constraints.NotNull;
import kg.esemp.bir_som_fondu.bir_som_fonduu.enums.Role;
import kg.esemp.bir_som_fondu.bir_som_fonduu.valid.PasswordValid;
import kg.esemp.bir_som_fondu.bir_som_fonduu.valid.PhoneNumberValid;
import lombok.*;


public record SignUpRequest (
        @NotNull(message = "Имя не может быть пустым")
        String firstName,
        @NotNull(message = "Фамилия не может быть пустой")
        String lastName,
        @NotNull(message = "Номер телефона обязателен")
        @PhoneNumberValid
        String phone,
        @NotNull(message = "Пароль обязателен")
        @PasswordValid
        String password,
        @NotNull(message = "Роль обязательна")
        Role role ){




}

