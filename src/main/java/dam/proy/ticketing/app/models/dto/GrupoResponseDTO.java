package dam.proy.ticketing.app.models.dto;

public class GrupoResponseDTO {

    private int id;
    private String nombre;

    public GrupoResponseDTO() {
    }

    public GrupoResponseDTO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "GrupoResponseDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
