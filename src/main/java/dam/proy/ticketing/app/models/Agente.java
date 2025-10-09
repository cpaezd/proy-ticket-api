package dam.proy.ticketing.app.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="agentes")
public class Agente {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name="grupo")
    private Grupo grupo;

    @OneToMany(mappedBy = "agente")
    private List<Ticket> tickets;

    //Al tener herencia de usuario necesitamos agregar la etiqueta MasId a la relación OnetoOne

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Usuario usuario;

    public Agente() {
    }

    public Agente(Usuario usuario, List<Ticket> tickets, Grupo grupo, int id) {
        this.usuario = usuario;
        this.tickets = tickets;
        this.grupo = grupo;
        this.id = id;
    }

    public Agente(int id) {
        this.id = id;
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

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "Agente{" +
                "id=" + id +
                ", grupo=" + grupo +
                ", tickets=" + tickets +
                ", usuario=" + usuario +
                '}';
    }
}
