package dam.proy.ticketing.app.models.dto;

import dam.proy.ticketing.app.models.Usuario;

public class UsuarioDTO {

    private int id;
    private String nombre;
    private String apellidos;
    private String email;
    private String perfil;
    private boolean activo;

    public UsuarioDTO() {}

    public UsuarioDTO(int id, String nombre, String apellidos, String email, String perfil, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.perfil = perfil;
        this.activo = activo;
    }

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nombre = usuario.getNombre();
        this.apellidos = usuario.getApellidos();
        this.email = usuario.getEmail();
        this.perfil = usuario.getPerfil().getNombre();
        this.activo = usuario.isActivo();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}