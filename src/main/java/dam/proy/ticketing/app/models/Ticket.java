package dam.proy.ticketing.app.models;

import dam.proy.ticketing.app.models.enums.EstadoTicket;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String asunto;

    @Column
    private String descripcion;

    @Column
    private LocalDateTime fechaCreacion;

    @Column(name="estado")
    @Enumerated(EnumType.STRING)
    private EstadoTicket estadoTicket;

    @Column
    private String urgencia;

    @Column
    private String impacto;

    @Column
    private String prioridad;

    @ManyToOne
    @JoinColumn(name = "grupo")
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name="solicitante")
    private Solicitante solicitante;

    @ManyToOne
    @JoinColumn(name = "tecnico")
    private Agente agente;

    @OneToMany(mappedBy = "ticket")
    private List<Historial> historiales;

    @OneToMany(mappedBy = "ticket")
    private List<Anotacion> anotaciones;

    public Ticket() {
    }

    public Ticket(int id, String asunto, String descripcion, LocalDateTime fechaCreacion, EstadoTicket estadoTicket, String urgencia, String impacto, String prioridad) {
        this.id = id;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.estadoTicket = estadoTicket;
        this.urgencia = urgencia;
        this.impacto = impacto;
        this.prioridad = prioridad;
    }

    public Ticket(int id, List<Anotacion> anotaciones, List<Historial> historiales, Agente agente, Solicitante solicitante, Grupo grupo, String prioridad, String impacto, String urgencia, EstadoTicket estadoTicket, LocalDateTime fechaCreacion, String descripcion, String asunto) {
        this.id = id;
        this.anotaciones = anotaciones;
        this.historiales = historiales;
        this.agente = agente;
        this.solicitante = solicitante;
        this.grupo = grupo;
        this.prioridad = prioridad;
        this.impacto = impacto;
        this.urgencia = urgencia;
        this.estadoTicket = estadoTicket;
        this.fechaCreacion = fechaCreacion;
        this.descripcion = descripcion;
        this.asunto = asunto;
    }

	@Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", asunto='" + asunto + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", estadoTicket=" + estadoTicket +
                ", urgencia='" + urgencia + '\'' +
                ", impacto='" + impacto + '\'' +
                ", prioridad='" + prioridad + '\'' +
                ", grupo=" + grupo +
                ", solicitante=" + solicitante +
                ", agente=" + agente +
                ", historiales=" + historiales +
                ", anotaciones=" + anotaciones +
                '}';
    }
}
