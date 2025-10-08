package dam.proy.ticketing.app.models;

public class Usuario {
    private int id;
    private String nombre;
    private String apellidos;
    private String email;
    private boolean activo;
    private String password;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellidos, String email, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.activo = activo;
    }


}
