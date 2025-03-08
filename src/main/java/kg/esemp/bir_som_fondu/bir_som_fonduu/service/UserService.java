package kg.esemp.bir_som_fondu.bir_som_fonduu.service;

import kg.esemp.bir_som_fondu.bir_som_fonduu.config.request.UserRequest;
import kg.esemp.bir_som_fondu.bir_som_fonduu.config.responce.UserResponse;

import java.util.Optional;

public interface UserService {


    Optional<UserResponse> getUserById(Long userId);

    UserResponse updateUser(Long id, UserRequest userRequest);
}
