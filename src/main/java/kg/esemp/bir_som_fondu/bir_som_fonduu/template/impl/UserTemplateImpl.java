package kg.esemp.bir_som_fondu.bir_som_fonduu.template.impl;

import kg.esemp.bir_som_fondu.bir_som_fonduu.config.responce.UserResponse;
import kg.esemp.bir_som_fondu.bir_som_fonduu.dto.User;
import kg.esemp.bir_som_fondu.bir_som_fonduu.repository.UserRepository;
import kg.esemp.bir_som_fondu.bir_som_fonduu.template.UserTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserTemplateImpl implements UserTemplate {

    private final UserRepository userRepository;  // Репозиторий для работы с пользователями

    @Override
    public Optional<UserResponse> getUserById(Long id) {
        // Ищем пользователя по ID
        Optional<User> user = userRepository.findById(id);

        // Если пользователь найден, конвертируем его в UserResponse
        return user.map(this::convertToUserResponse);
    }

    // Преобразуем User в UserResponse
    private UserResponse convertToUserResponse(User user) {
        return new UserResponse(
                user.getFirstName(),
                user.getLastName(),
                user.getPhone()
        );
    }
}
