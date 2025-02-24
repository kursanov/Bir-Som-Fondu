package kg.esemp.bir_som_fondu.bir_som_fonduu.config.authservice;

import kg.esemp.bir_som_fondu.bir_som_fonduu.config.JwtService;
import kg.esemp.bir_som_fondu.bir_som_fonduu.config.request.SignInRequest;
import kg.esemp.bir_som_fondu.bir_som_fonduu.config.request.SignUpRequest;
import kg.esemp.bir_som_fondu.bir_som_fonduu.config.responce.AuthenticationResponse;
import kg.esemp.bir_som_fondu.bir_som_fonduu.dto.User;
import kg.esemp.bir_som_fondu.bir_som_fonduu.exeption.BadCredentialException;
import kg.esemp.bir_som_fondu.bir_som_fonduu.exeption.BadRequestException;
import kg.esemp.bir_som_fondu.bir_som_fonduu.exeption.NotFoundException;
import kg.esemp.bir_som_fondu.bir_som_fonduu.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }


    // Ваш метод signUp
    public User signUp(SignUpRequest signUpRequest) {
        // Проверяем, существует ли пользователь с таким номером телефона
        if (userRepository.existsByPhone(signUpRequest.phone())) {
            throw new BadRequestException("Пользователь с таким номером телефона уже существует!");
        }

        // Проверяем, существует ли пользователь с таким же паролем
        if (userRepository.existsByPassword(passwordEncoder.encode(signUpRequest.password()))) {
            throw new BadRequestException("Этот пароль уже используется!");
        }

        // Создаем нового пользователя
        User user = new User();
        user.setFirstName(signUpRequest.firstName());
        user.setLastName(signUpRequest.lastName());
        user.setRole(signUpRequest.role());
        user.setPassword(passwordEncoder.encode(signUpRequest.password()));
        user.setPhone(signUpRequest.phone());
        user.setCreatedDate(LocalDate.now());

        // Сохраняем пользователя в базе данных
        return userRepository.save(user);
    }


    @Override
    public AuthenticationResponse signIn(SignInRequest signInRequest) {
        // Находим пользователя по номеру телефона
        User user = userRepository.getUserPhone(signInRequest.getPhone()).orElseThrow(() ->
                new NotFoundException("Пользователь с номером " + signInRequest.getPhone() + " не найден!"));

        // Проверяем, совпадает ли введенный пароль с сохраненным
        if (!passwordEncoder.matches(signInRequest.getPassword(), user.getPassword())) {
            throw new BadCredentialException("Неверный пароль");
        }

        // Генерация токена с использованием JwtService
        String token = jwtService.generateToken(user);  // Используем ваш JwtService для генерации токена

        // Возвращаем AuthenticationResponse с токеном и данными пользователя
        return AuthenticationResponse.builder()
                .token(token)
                .phone(user.getPhone())
                .role(user.getRole())
                .build();
    }
}
