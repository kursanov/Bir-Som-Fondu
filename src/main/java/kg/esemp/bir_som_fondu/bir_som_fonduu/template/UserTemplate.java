package kg.esemp.bir_som_fondu.bir_som_fonduu.template;

import kg.esemp.bir_som_fondu.bir_som_fonduu.config.responce.UserResponse;

import java.util.Optional;

public interface UserTemplate {

    Optional<UserResponse> getUserById (Long id);
}
