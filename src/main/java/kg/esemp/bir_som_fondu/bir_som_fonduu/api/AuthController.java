package kg.esemp.bir_som_fondu.bir_som_fonduu.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import kg.esemp.bir_som_fondu.bir_som_fonduu.config.authservice.AuthService;
import kg.esemp.bir_som_fondu.bir_som_fonduu.config.request.SignInRequest;
import kg.esemp.bir_som_fondu.bir_som_fonduu.config.request.SignUpRequest;
import kg.esemp.bir_som_fondu.bir_som_fonduu.config.responce.AuthenticationResponse;
import kg.esemp.bir_som_fondu.bir_som_fonduu.config.responce.JwtResponse;
import kg.esemp.bir_som_fondu.bir_som_fonduu.config.JwtService;
import kg.esemp.bir_som_fondu.bir_som_fonduu.config.responce.UserResponse;
import kg.esemp.bir_som_fondu.bir_som_fonduu.dto.User;
import kg.esemp.bir_som_fondu.bir_som_fonduu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtService jwtService;

    private final UserService userService;

    @Autowired
    public AuthController(AuthService authService, JwtService jwtService, UserService userService) {
        this.authService = authService;
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @PostMapping("/signUp")
    @ApiResponse(responseCode = "400", description = "Ошибка валидации",
            content = @Content(schema = @Schema(implementation = Map.class)))
    @Operation(
            summary = "Метод для регистрации новых пользователей!",
            description = "Права на метод имеют все!")
    public ResponseEntity<JwtResponse> signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
        User registeredUser = authService.signUp(signUpRequest);
        String token = jwtService.generateToken(registeredUser);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/signIn")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Неверный запрос: ошибки валидации"),
            @ApiResponse(responseCode = "404", description = "Пользователь не найден")
    })
    @Operation(
            summary = "Метод для авторизации(проверка подлинности)пользователей, сохраненных в базе данных!",
            description = "Права на метод имеют все!")
    public AuthenticationResponse signIn (@Valid @RequestBody SignInRequest sign){
        return authService.signIn(sign);
    }



}


