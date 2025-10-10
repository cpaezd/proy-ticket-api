package dam.proy.ticketing.app.dto;

public class LoginRespuestaDTO {

    private String token;
    private int id_perfil;
    private String nombre_perfil;
    private String nombre;
    private String apellidos;
    private String email;

    public LoginRespuestaDTO() {
    }

    public LoginRespuestaDTO(String token, String email, String apellidos, String nombre, String nombre_perfil, int id_perfil) {
        this.token = token;
        this.email = email;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.nombre_perfil = nombre_perfil;
        this.id_perfil = id_perfil;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre_perfil() {
        return nombre_perfil;
    }

    public void setNombre_perfil(String nombre_perfil) {
        this.nombre_perfil = nombre_perfil;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    @Override
    public String toString() {
        return "LoginRespuestaDTO{" +
                "token='" + token + '\'' +
                ", id_perfil=" + id_perfil +
                ", nombre_perfil='" + nombre_perfil + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
