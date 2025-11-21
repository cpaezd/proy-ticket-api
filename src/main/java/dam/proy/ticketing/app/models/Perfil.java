package dam.proy.ticketing.app.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name= "perfiles")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

    @OneToMany(mappedBy = "perfil")
    @JsonIgnore
    private List<Usuario> usuarios;

    public Perfil() {
    }

    public Perfil(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Perfil(int id, List<Usuario> usuarios, String nombre) {
        this.id = id;
        this.usuarios = usuarios;
        this.nombre = nombre;
    }

	public Perfil(int id) {
        this.id = id;
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", usuarios=" + usuarios +
                '}';
    }
}
