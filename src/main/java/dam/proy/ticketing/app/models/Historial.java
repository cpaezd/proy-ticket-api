package dam.proy.ticketing.app.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="historial")
public class Historial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private LocalDateTime fecha;

    @Column
    private String detalles;

    @ManyToOne
    @JoinColumn(name = "ticket")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    public Historial() {
    }

    public Historial(int id, LocalDateTime fecha, String detalles, Ticket ticket, Usuario usuario) {
        this.id = id;
        this.fecha = fecha;
        this.detalles = detalles;
        this.ticket = ticket;
        this.usuario = usuario;
    }

    public Historial(int id, String detalles, LocalDateTime fecha) {
        this.id = id;
        this.detalles = detalles;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Historial{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", detalles='" + detalles + '\'' +
                ", ticket=" + ticket +
                ", usuario=" + usuario +
                '}';
    }
}
