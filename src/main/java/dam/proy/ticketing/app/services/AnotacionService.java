package dam.proy.ticketing.app.services;

import dam.proy.ticketing.app.models.Anotacion;
import dam.proy.ticketing.app.models.Ticket;
import dam.proy.ticketing.app.repositories.AnotacionRepository;
import dam.proy.ticketing.app.services.interfaces.IAnotacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnotacionService implements IAnotacionService {
    @Autowired
    private AnotacionRepository anotacionRepository;

    @Override
    public List<Anotacion> getAnotacionesByTicket(Ticket ticket) {
       return this.anotacionRepository.getAnotacionesByTicket(ticket);
    }
}