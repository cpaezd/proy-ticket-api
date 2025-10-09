package dam.proy.ticketing.app.models;

import jakarta.persistence.*;

@Entity
@Table(name="historial")
public class Historial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String accion;

    @Column
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "ticket")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    public Historial() {
    }

    public Historial(int id, String contenido, String accion) {
        this.id = id;
        this.contenido = contenido;
        this.accion = accion;
    }

    public Historial(int id, Usuario usuario, Ticket ticket, String contenido, String accion) {
        this.id = id;
        this.usuario = usuario;
        this.ticket = ticket;
        this.contenido = contenido;
        this.accion = accion;
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

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    @Override
    public String toString() {
        return "Historial{" +
                "id=" + id +
                ", accion='" + accion + '\'' +
                ", contenido='" + contenido + '\'' +
                ", ticket=" + ticket +
                ", usuario=" + usuario +
                '}';
    }
}
