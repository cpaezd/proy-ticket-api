package dam.proy.ticketing.app.services.interfaces;

import dam.proy.ticketing.app.models.Ticket;
import dam.proy.ticketing.app.models.Usuario;
import dam.proy.ticketing.app.models.dto.TicketDTO;

import java.util.List;

public interface ITicketService {

    public List<Ticket> verActivos();
    public TicketDTO buscarPorId(int id);
    public Ticket editarTicket(int id, Ticket ticket, String email);


}
