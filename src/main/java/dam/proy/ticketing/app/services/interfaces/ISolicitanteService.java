package dam.proy.ticketing.app.services.interfaces;


import dam.proy.ticketing.app.models.dto.TicketCreacionDTO;
import dam.proy.ticketing.app.models.Ticket;
import java.util.List;

public interface ISolicitanteService {

    /**
     * Define el método para obtener tickets.
     */
    List<Ticket> obtenerTicketsPorEmail(String email);

    /**
     * Define el método para crear un ticket.
     */
    Ticket crearTicket(TicketCreacionDTO ticketDTO, String email);
}