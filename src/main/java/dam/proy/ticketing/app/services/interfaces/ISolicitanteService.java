package dam.proy.ticketing.app.services.interfaces;


import dam.proy.ticketing.app.models.Solicitante;
import dam.proy.ticketing.app.models.Ticket;
import dam.proy.ticketing.app.models.dto.TicketCreacionDTO;

import java.util.List;

public interface ISolicitanteService {
    Solicitante nuevoSolicitante(Solicitante solicitante);
    Solicitante getSolicitante(int id);
    Solicitante updateSolicitante(Solicitante solicitante);

    /**
     * Define el método para obtener tickets.
     */
    List<Ticket> obtenerTicketsPorEmail(String email);

    /**
     * Define el método para crear un ticket.
     */
    Ticket crearTicket(TicketCreacionDTO ticketDTO, String email);
}