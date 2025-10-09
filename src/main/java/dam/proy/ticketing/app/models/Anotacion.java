package dam.proy.ticketing.app.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="anotaciones")
public class Anotacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="visibilidad")
    @Enumerated(EnumType.STRING)
    private VisibilidadTicket visibilidadTicket;

    @Column
    private String descripcion;

    @Column
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "ticket")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    public Anotacion() {
    }

    public Anotacion(int id, VisibilidadTicket visibilidadTicket, String descripcion, LocalDateTime fecha) {
        this.id = id;
        this.visibilidadTicket = visibilidadTicket;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public Anotacion(int id, Usuario usuario, Ticket ticket, LocalDateTime fecha, String descripcion, VisibilidadTicket visibilidadTicket) {
        this.id = id;
        this.usuario = usuario;
        this.ticket = ticket;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.visibilidadTicket = visibilidadTicket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public VisibilidadTicket getVisibilidadTicket() {
        return visibilidadTicket;
    }

    public void setVisibilidadTicket(VisibilidadTicket visibilidadTicket) {
        this.visibilidadTicket = visibilidadTicket;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
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
        return "Anotacion{" +
                "id=" + id +
                ", visibilidadTicket=" + visibilidadTicket +
                ", descripcion='" + descripcion + '\'' +
                ", fecha=" + fecha +
                ", ticket=" + ticket +
                ", usuario=" + usuario +
                '}';
    }
}
