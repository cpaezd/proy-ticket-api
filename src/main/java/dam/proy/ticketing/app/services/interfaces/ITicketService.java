package dam.proy.ticketing.app.services.interfaces;

import dam.proy.ticketing.app.models.Ticket;

import java.util.List;

public interface ITicketService {
    List<Ticket> verTodos();
    Ticket getTicket(int ticket);
    List<Ticket> getTicketsBySolicitante(int solicitante);
    List<Ticket> getTicketsByGrupo(int Grupo);

}
