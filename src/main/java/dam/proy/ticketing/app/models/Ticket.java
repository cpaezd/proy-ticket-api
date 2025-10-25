package dam.proy.ticketing.app.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dam.proy.ticketing.app.models.enums.EstadoTicket;
import dam.proy.ticketing.app.models.enums.ImpactoTicket;
import dam.proy.ticketing.app.models.enums.PrioridadTicket;
import dam.proy.ticketing.app.models.enums.UrgenciaTicket;
import jakarta.persistence.*;

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
    @Enumerated(EnumType.STRING)
    private UrgenciaTicket urgencia;

    @Column
    @Enumerated(EnumType.STRING)
    private ImpactoTicket impacto;

    @Column
    @Enumerated(EnumType.STRING)
    private PrioridadTicket prioridad;

    @Column
    private LocalDateTime fecha_resolucion;

    @Column
    private LocalDateTime fecha_cierre;
    @Column
    private Integer responsable;

    @ManyToOne
    @JoinColumn(name = "grupo")
    @JsonBackReference("ticket-grupo")
    private Grupo grupo;

    @ManyToOne
    @JoinColumn(name="solicitante")
    @JsonBackReference("ticket-solicitante")
    private Solicitante solicitante;

    @ManyToOne
    @JoinColumn(name = "tecnico")
    @JsonBackReference("ticket-agente")
    private Agente agente;

    @OneToMany(mappedBy = "ticket")
    @JsonManagedReference
    private List<Historial> historiales;

    @OneToMany(mappedBy = "ticket")
    @JsonManagedReference
    private List<Anotacion> anotaciones;

    public Ticket() {
    }

    public Ticket(int id) {
        this.id = id;
    }

    public Ticket(int id, String asunto, String descripcion, LocalDateTime fechaCreacion, EstadoTicket estadoTicket, UrgenciaTicket urgencia, ImpactoTicket impacto, PrioridadTicket prioridad) {
        this.id = id;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.estadoTicket = estadoTicket;
        this.urgencia = urgencia;
        this.impacto = impacto;
        this.prioridad = prioridad;
    }

    public Ticket(int id, List<Anotacion> anotaciones, List<Historial> historiales, Agente agente, Solicitante solicitante, Grupo grupo, PrioridadTicket prioridad, ImpactoTicket impacto, UrgenciaTicket urgencia, EstadoTicket estadoTicket, LocalDateTime fechaCreacion, String descripcion, String asunto) {
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

    public Ticket(int id, LocalDateTime fecha_cierre, LocalDateTime fecha_resolucion, ImpactoTicket impacto, PrioridadTicket prioridad, UrgenciaTicket urgencia, EstadoTicket estadoTicket, LocalDateTime fechaCreacion, String descripcion, String asunto) {
        this.id = id;
        this.fecha_cierre = fecha_cierre;
        this.fecha_resolucion = fecha_resolucion;
        this.impacto = impacto;
        this.prioridad = prioridad;
        this.urgencia = urgencia;
        this.estadoTicket = estadoTicket;
        this.fechaCreacion = fechaCreacion;
        this.descripcion = descripcion;
        this.asunto = asunto;
    }

    public Ticket(int id, List<Anotacion> anotaciones, List<Historial> historiales, Solicitante solicitante, Agente agente, Grupo grupo, LocalDateTime fecha_cierre, LocalDateTime fecha_resolucion, PrioridadTicket prioridad, UrgenciaTicket urgencia, ImpactoTicket impacto, EstadoTicket estadoTicket, LocalDateTime fechaCreacion, String descripcion, String asunto) {
        this.id = id;
        this.anotaciones = anotaciones;
        this.historiales = historiales;
        this.solicitante = solicitante;
        this.agente = agente;
        this.grupo = grupo;
        this.fecha_cierre = fecha_cierre;
        this.fecha_resolucion = fecha_resolucion;
        this.prioridad = prioridad;
        this.urgencia = urgencia;
        this.impacto = impacto;
        this.estadoTicket = estadoTicket;
        this.fechaCreacion = fechaCreacion;
        this.descripcion = descripcion;
        this.asunto = asunto;
    }

    public Ticket(int id, List<Anotacion> anotaciones, List<Historial> historiales, Agente agente, Solicitante solicitante, Grupo grupo, int responsable, LocalDateTime fecha_cierre, LocalDateTime fecha_resolucion, ImpactoTicket impacto, PrioridadTicket prioridad, UrgenciaTicket urgencia, EstadoTicket estadoTicket, LocalDateTime fechaCreacion, String descripcion, String asunto) {
        this.id = id;
        this.anotaciones = anotaciones;
        this.historiales = historiales;
        this.agente = agente;
        this.solicitante = solicitante;
        this.grupo = grupo;
        this.responsable = responsable;
        this.fecha_cierre = fecha_cierre;
        this.fecha_resolucion = fecha_resolucion;
        this.impacto = impacto;
        this.prioridad = prioridad;
        this.urgencia = urgencia;
        this.estadoTicket = estadoTicket;
        this.fechaCreacion = fechaCreacion;
        this.descripcion = descripcion;
        this.asunto = asunto;
    }

    public Integer getResponsable() {
        return responsable;
    }

    public void setResponsable(Integer responsable) {
        this.responsable = responsable;
    }

    public LocalDateTime getFecha_resolucion() {
        return fecha_resolucion;
    }

    public void setFecha_resolucion(LocalDateTime fecha_resolucion) {
        this.fecha_resolucion = fecha_resolucion;
    }

    public LocalDateTime getFecha_cierre() {
        return fecha_cierre;
    }

    public void setFecha_cierre(LocalDateTime fecha_cierre) {
        this.fecha_cierre = fecha_cierre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public EstadoTicket getEstadoTicket() {
        return estadoTicket;
    }

    public void setEstadoTicket(EstadoTicket estadoTicket) {
        this.estadoTicket = estadoTicket;
    }

    public UrgenciaTicket getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(UrgenciaTicket urgencia) {
        this.urgencia = urgencia;
    }

    public ImpactoTicket getImpacto() {
        return impacto;
    }

    public void setImpacto(ImpactoTicket impacto) {
        this.impacto = impacto;
    }

    public PrioridadTicket getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(PrioridadTicket prioridad) {
        this.prioridad = prioridad;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public List<Historial> getHistoriales() {
        return historiales;
    }

    public void setHistoriales(List<Historial> historiales) {
        this.historiales = historiales;
    }

    public List<Anotacion> getAnotaciones() {
        return anotaciones;
    }

    public void setAnotaciones(List<Anotacion> anotaciones) {
        this.anotaciones = anotaciones;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", asunto='" + asunto + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", estadoTicket=" + estadoTicket +
                ", urgencia=" + urgencia +
                ", impacto=" + impacto +
                ", prioridad=" + prioridad +
                ", fecha_resolucion=" + fecha_resolucion +
                ", fecha_cierre=" + fecha_cierre +
                ", responsable=" + responsable +
                ", grupo=" + grupo +
                ", solicitante=" + solicitante +
                ", agente=" + agente +
                ", historiales=" + historiales +
                ", anotaciones=" + anotaciones +
                '}';
    }
}
