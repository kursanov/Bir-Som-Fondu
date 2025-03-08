package kg.esemp.bir_som_fondu.bir_som_fonduu.service.impl;

import kg.esemp.bir_som_fondu.bir_som_fonduu.config.request.UserRequest;
import kg.esemp.bir_som_fondu.bir_som_fonduu.config.responce.UserResponse;
import kg.esemp.bir_som_fondu.bir_som_fonduu.exeption.NotFoundException;
import kg.esemp.bir_som_fondu.bir_som_fonduu.service.UserService;
import kg.esemp.bir_som_fondu.bir_som_fonduu.template.impl.UserTemplateImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserTemplateImpl userTemplate;
    @Override
    public Optional<UserResponse> getUserById(Long userId) {
        return Optional.ofNullable(userTemplate.getUserById(userId).orElseThrow(() ->
                new NotFoundException("C таким  ID: "+ userId +" user не  найден.")));
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest userRequest) {
        return null;
    }
}
