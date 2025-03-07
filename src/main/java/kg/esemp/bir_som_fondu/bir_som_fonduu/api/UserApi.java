package kg.esemp.bir_som_fondu.bir_som_fonduu.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kg.esemp.bir_som_fondu.bir_som_fonduu.config.responce.UserResponse;
import kg.esemp.bir_som_fondu.bir_som_fonduu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User-api")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class UserApi {


    private final UserService userService;


    @PreAuthorize("hasAuthority('DONOR')")
    @GetMapping("/{userId}")
    @Operation(
            summary = "Получение профиля пользователя по идентификатору",
            description = """
            Этот метод позволяет получить профиль пользователя по указанному идентификатору.
            В запросе используется идентификатор пользователя в URL.
           Параметры:
            - `userId`: Идентификатор пользователя, чей профиль нужно получить.
        """)
    public Optional<UserResponse> getByUserId(@PathVariable Long userId){
        return userService.getUserById(userId);

    }

}
