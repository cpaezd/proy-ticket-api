package dam.proy.ticketing.app.models.dto;

import dam.proy.ticketing.app.models.Agente;
import dam.proy.ticketing.app.models.Grupo;
import dam.proy.ticketing.app.models.Solicitante;
import dam.proy.ticketing.app.models.Ticket;
import dam.proy.ticketing.app.models.enums.EstadoTicket;
import dam.proy.ticketing.app.models.enums.ImpactoTicket;
import dam.proy.ticketing.app.models.enums.PrioridadTicket;
import dam.proy.ticketing.app.models.enums.UrgenciaTicket;

import java.time.LocalDateTime;

public class TicketDTO
{
	private int ticketId;
	private String asunto;
	private String descripcion;
	private LocalDateTime fechaCreacion;
	private EstadoTicket estado;
	private UrgenciaTicket urgencia;
	private ImpactoTicket impacto;
	private PrioridadTicket prioridad;
	private String grupo;
	private String agente;
	private String solicitante;

	public TicketDTO() {}

	public TicketDTO(Ticket ticket, Solicitante solicitante, Grupo grupo, Agente agente)
	{
		this.ticketId = ticket.getId();
		this.asunto = ticket.getAsunto();
		this.descripcion = ticket.getDescripcion();
		this.fechaCreacion = ticket.getFechaCreacion();
		this.estado = ticket.getEstadoTicket();
		this.urgencia = ticket.getUrgencia();
		this.impacto = ticket.getImpacto();
		this.prioridad = ticket.getPrioridad();
		this.grupo = grupo.getNombre();
		this.agente = agente.getUsuario().getNombre();
		this.solicitante = solicitante.getUsuario().getNombre();
	}

	public TicketDTO(int ticketId, String asunto, String descripcion, LocalDateTime fechaCreacion, EstadoTicket estado, UrgenciaTicket urgencia, ImpactoTicket impacto, PrioridadTicket prioridad, String grupo, String agente, String solicitante) {
		this.ticketId = ticketId;
		this.asunto = asunto;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.urgencia = urgencia;
		this.impacto = impacto;
		this.prioridad = prioridad;
		this.grupo = grupo;
		this.agente = agente;
		this.solicitante = solicitante;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
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

	public EstadoTicket getEstado() {
		return estado;
	}

	public void setEstado(EstadoTicket estado) {
		this.estado = estado;
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

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getAgente() {
		return agente;
	}

	public void setAgente(String agente) {
		this.agente = agente;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}
}
