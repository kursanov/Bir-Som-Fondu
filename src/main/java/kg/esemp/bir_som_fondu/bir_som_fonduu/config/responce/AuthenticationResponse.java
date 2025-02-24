package kg.esemp.bir_som_fondu.bir_som_fonduu.config.responce;

import kg.esemp.bir_som_fondu.bir_som_fonduu.enums.Role;
import lombok.Builder;

@Builder
public record AuthenticationResponse (
        String token,
        String phone,

        Role role
){
}
