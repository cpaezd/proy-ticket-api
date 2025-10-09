package dam.proy.ticketing.app.services;

import dam.proy.ticketing.app.repositories.TicketRepository;
import dam.proy.ticketing.app.services.interfaces.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService implements ITicketService {

    @Autowired
    private TicketRepository ticketRepository;
}
