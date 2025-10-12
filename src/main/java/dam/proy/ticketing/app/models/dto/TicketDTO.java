package dam.proy.ticketing.app.models.dto;

import dam.proy.ticketing.app.models.Anotacion;
import dam.proy.ticketing.app.models.Historial;
import dam.proy.ticketing.app.models.enums.EstadoTicket;
import dam.proy.ticketing.app.models.enums.ImpactoTicket;
import dam.proy.ticketing.app.models.enums.PrioridadTicket;
import dam.proy.ticketing.app.models.enums.UrgenciaTicket;

import java.time.LocalDateTime;
import java.util.List;

public class TicketDTO {
    private int id;
    private String asunto;
    private String descripcion;
    private LocalDateTime fechaCreacion;
    private EstadoTicket estadoTicket;
    private UrgenciaTicket urgencia;
    private ImpactoTicket impacto;
    private PrioridadTicket prioridad;
    private String grupo;
    private String tecnico;
    private String solicitante;
    private List<Historial> historiales;
    private List<Anotacion> anotaciones;

    public TicketDTO() {
    }
    public TicketDTO(int id, String asunto, String descripcion, String solicitante) {
        this.id = id;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.solicitante = solicitante;
    }

    public TicketDTO(int id, List<Anotacion> anotaciones, List<Historial> historiales, String tecnico, String solicitante, String grupo, PrioridadTicket prioridad, ImpactoTicket impacto, UrgenciaTicket urgencia, EstadoTicket estadoTicket, LocalDateTime fechaCreacion, String descripcion, String asunto) {
        this.id = id;
        this.anotaciones = anotaciones;
        this.historiales = historiales;
        this.tecnico = tecnico;
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

    public List<Anotacion> getAnotaciones() {
        return anotaciones;
    }

    public void setAnotaciones(List<Anotacion> anotaciones) {
        this.anotaciones = anotaciones;
    }

    public List<Historial> getHistoriales() {
        return historiales;
    }

    public void setHistoriales(List<Historial> historiales) {
        this.historiales = historiales;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public PrioridadTicket getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(PrioridadTicket prioridad) {
        this.prioridad = prioridad;
    }

    public ImpactoTicket getImpacto() {
        return impacto;
    }

    public void setImpacto(ImpactoTicket impacto) {
        this.impacto = impacto;
    }

    public UrgenciaTicket getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(UrgenciaTicket urgencia) {
        this.urgencia = urgencia;
    }

    public EstadoTicket getEstadoTicket() {
        return estadoTicket;
    }

    public void setEstadoTicket(EstadoTicket estadoTicket) {
        this.estadoTicket = estadoTicket;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    @Override
    public String toString() {
        return "TicketDTO{" +
                "id=" + id +
                ", asunto='" + asunto + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", estadoTicket=" + estadoTicket +
                ", urgencia=" + urgencia +
                ", impacto=" + impacto +
                ", prioridad=" + prioridad +
                ", grupo='" + grupo + '\'' +
                ", tecnico='" + tecnico + '\'' +
                ", solicitante='" + solicitante + '\'' +
                ", historiales=" + historiales +
                ", anotaciones=" + anotaciones +
                '}';
    }
}
