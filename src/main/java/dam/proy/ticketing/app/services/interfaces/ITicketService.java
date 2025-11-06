package dam.proy.ticketing.app.services.interfaces;

import dam.proy.ticketing.app.models.Ticket;
import dam.proy.ticketing.app.models.dto.TicketDTO;

import java.util.List;

public interface ITicketService {

    public List<Ticket> verActivosParaAgente(int id_usuario);
    public List<Ticket> verResueltosCerrados();
    public TicketDTO buscarPorId(int id);
    public Ticket editarTicket(int id, Ticket ticket, String email);
    public List<TicketDTO> buscarPorGrupo(int id_grupo,int id_usuario);
    public List<TicketDTO> buscarPorGrupoResueltos(int id_grupo);
    public Ticket asignarResponsable( int id_ticket, int id_usuario);
    public Ticket designarResponsable(int id_ticket);
    public List<Ticket> verTicketAsignadosAgente(int id_usuario);
    public void liberarTickets(int id_usuario);
    public boolean dropearTicket(int id_ticket);

    public Ticket asignarResponsableTecnico(int id_ticket, int id_usuario);
    public Ticket desasignarResponsableTecnico(int id_ticket);
    public List<Ticket> verTicketsAsignadosTecnico(int id_usuario);
    public void liberarTicketsTecnico(int id_usuario);
    public boolean dropearTicketTecnico(int id_ticket);

}
