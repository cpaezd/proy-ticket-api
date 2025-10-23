package dam.proy.ticketing.app.services.interfaces;

import dam.proy.ticketing.app.models.Ticket;
import dam.proy.ticketing.app.models.dto.TicketDTO;

import java.util.List;

public interface ITicketService {

    public List<Ticket> verActivos();
    public List<Ticket> verResueltosCerrados();
    public TicketDTO buscarPorId(int id);
    public Ticket editarTicket(int id, Ticket ticket, String email);
    public List<TicketDTO> buscarPorGrupo(int id_grupo);
    public List<TicketDTO> buscarPorGrupoResueltos(int id_grupo);


}
