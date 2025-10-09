package dam.proy.ticketing.app.models;

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

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public String getImpacto() {
        return impacto;
    }

    public void setImpacto(String impacto) {
        this.impacto = impacto;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
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
