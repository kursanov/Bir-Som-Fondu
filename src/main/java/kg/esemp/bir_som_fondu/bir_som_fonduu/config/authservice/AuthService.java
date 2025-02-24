package kg.esemp.bir_som_fondu.bir_som_fonduu.config.authservice;

import kg.esemp.bir_som_fondu.bir_som_fonduu.config.request.SignInRequest;
import kg.esemp.bir_som_fondu.bir_som_fonduu.config.request.SignUpRequest;
import kg.esemp.bir_som_fondu.bir_som_fonduu.config.responce.AuthenticationResponse;
import kg.esemp.bir_som_fondu.bir_som_fonduu.dto.User;

public interface AuthService {

    User signUp(SignUpRequest signUpRequest);

    AuthenticationResponse signIn(SignInRequest signInRequest);

}
