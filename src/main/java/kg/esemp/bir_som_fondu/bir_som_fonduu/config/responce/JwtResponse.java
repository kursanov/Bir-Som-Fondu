package kg.esemp.bir_som_fondu.bir_som_fonduu.config.responce;
public class JwtResponse {
    private String token;

    public JwtResponse(String token) { // Конструктор с параметром
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

