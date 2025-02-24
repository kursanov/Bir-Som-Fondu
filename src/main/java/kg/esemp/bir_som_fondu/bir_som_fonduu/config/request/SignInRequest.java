package kg.esemp.bir_som_fondu.bir_som_fonduu.config.request;

import kg.esemp.bir_som_fondu.bir_som_fonduu.valid.PasswordValid;
import kg.esemp.bir_som_fondu.bir_som_fonduu.valid.PhoneExists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class SignInRequest {
    @PhoneExists(message = "Пользователь  с таким номером нет! Вам не обхадима регитировать!")
    @PasswordValid
    private String phone;
    private String password;
}
