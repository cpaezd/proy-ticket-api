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
    private int id_grupo;
    private int id_tecnico;
    private LocalDateTime fecha_resolucion;

    public TicketDTO() {
    }
    public TicketDTO(int id, String asunto, String descripcion, String solicitante) {
        this.id = id;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.solicitante = solicitante;
    }

    public TicketDTO(int id, String asunto, String descripcion, LocalDateTime fechaCreacion, EstadoTicket estadoTicket, UrgenciaTicket urgencia, ImpactoTicket impacto, PrioridadTicket prioridad, String grupo, String tecnico, String solicitante, List<Historial> historiales, List<Anotacion> anotaciones, int id_grupo, int id_tecnico, LocalDateTime fecha_resolucion) {
        this.id = id;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.estadoTicket = estadoTicket;
        this.urgencia = urgencia;
        this.impacto = impacto;
        this.prioridad = prioridad;
        this.grupo = grupo;
        this.tecnico = tecnico;
        this.solicitante = solicitante;
        this.historiales = historiales;
        this.anotaciones = anotaciones;
        this.id_grupo = id_grupo;
        this.id_tecnico = id_tecnico;
        this.fecha_resolucion = fecha_resolucion;
    }

    public TicketDTO(LocalDateTime fecha_resolucion, int id_tecnico, int id_grupo, String solicitante, String tecnico, String grupo, PrioridadTicket prioridad, ImpactoTicket impacto, UrgenciaTicket urgencia, EstadoTicket estadoTicket, LocalDateTime fechaCreacion, String descripcion, String asunto, int id) {
        this.fecha_resolucion = fecha_resolucion;
        this.id_tecnico = id_tecnico;
        this.id_grupo = id_grupo;
        this.solicitante = solicitante;
        this.tecnico = tecnico;
        this.grupo = grupo;
        this.prioridad = prioridad;
        this.impacto = impacto;
        this.urgencia = urgencia;
        this.estadoTicket = estadoTicket;
        this.fechaCreacion = fechaCreacion;
        this.descripcion = descripcion;
        this.asunto = asunto;
        this.id = id;
    }

    public LocalDateTime getFecha_resolucion() {
        return fecha_resolucion;
    }

    public void setFecha_resolucion(LocalDateTime fecha_resolucion) {
        this.fecha_resolucion = fecha_resolucion;
    }

    public int getId() {
        return id;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public int getId_tecnico() {
        return id_tecnico;
    }

    public void setId_tecnico(int id_tecnico) {
        this.id_tecnico = id_tecnico;
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
                ", id_grupo=" + id_grupo +
                ", id_tecnico=" + id_tecnico +
                ", fecha_resolucion=" + fecha_resolucion +
                '}';
    }
}
