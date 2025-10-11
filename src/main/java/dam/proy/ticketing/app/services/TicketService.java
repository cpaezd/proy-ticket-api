package dam.proy.ticketing.app.services;

import dam.proy.ticketing.app.models.Ticket;
import dam.proy.ticketing.app.models.enums.EstadoTicket;
import dam.proy.ticketing.app.repositories.TicketRepository;
import dam.proy.ticketing.app.services.interfaces.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService implements ITicketService {

    @Autowired
    private TicketRepository ticketRepository;

    //Buscar todos los tickets excepto los de estado cerrado
    @Override
    public List<Ticket> verTodos() {

        List<Ticket> todos = ticketRepository.findAll();
        List<Ticket> filtrados = new ArrayList<>();

        for(Ticket item : todos){

            if(item.getEstadoTicket() != EstadoTicket.CERRADO){
                filtrados.add(item);
            }
        }

        return filtrados;

    }
    //Buscar un ticket por ID
    @Override
    public Ticket buscarPorId(int id) {
        return ticketRepository.findById(id).orElse(null);
    }
}
