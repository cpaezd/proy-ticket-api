package dam.proy.ticketing.app.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="solicitantes")
public class Solicitante {

    @Id
    private int id;

    @Column
    private String empresa;

    @Column
    private String telefono;

    @Column
    private String cif;

    @OneToMany(mappedBy = "solicitante")
    @JsonManagedReference
    private List<Ticket> tickets;

    //Aqui para poder hacer la herencia al tener una clave que se comporta como PK y FK a su vez necesitamos agregar la etiqueta MapsId

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Usuario usuario;

    public Solicitante() {
    }

    public Solicitante(int id, Usuario usuario, List<Ticket> tickets, String cif, String telefono, String empresa) {
        this.id = id;
        this.usuario = usuario;
        this.tickets = tickets;
        this.cif = cif;
        this.telefono = telefono;
        this.empresa = empresa;
    }

    public Solicitante(int id, String empresa, String telefono, String cif) {
        this.id = id;
        this.empresa = empresa;
        this.telefono = telefono;
        this.cif = cif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Solicitante{" +
                "id=" + id +
                ", empresa='" + empresa + '\'' +
                ", telefono='" + telefono + '\'' +
                ", cif='" + cif + '\'' +
                ", tickets=" + tickets +
                ", usuario=" + usuario +
                '}';
    }
}
