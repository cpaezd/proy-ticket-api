package dam.proy.ticketing.app.services;

import dam.proy.ticketing.app.models.Ticket;
import dam.proy.ticketing.app.repositories.TicketRepository;
import dam.proy.ticketing.app.services.interfaces.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements ITicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> verTodos() {
       return ticketRepository.findAll();
    }

    @Override
    public Ticket getTicket(int ticket) {
        return null;
    }

    @Override
    public List<Ticket> getTicketsBySolicitante(int solicitante) {
        return List.of();
    }

    @Override
    public List<Ticket> getTicketsByGrupo(int Grupo) {
        return List.of();
    }
}
