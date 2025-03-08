package kg.esemp.bir_som_fondu.bir_som_fonduu.config.request;

import jakarta.validation.constraints.Email;
import kg.esemp.bir_som_fondu.bir_som_fonduu.valid.PhoneNumberValid;

public record UserRequest (
        String firstName,
         String lastName,
        @PhoneNumberValid
        String phoneNumber){

}
