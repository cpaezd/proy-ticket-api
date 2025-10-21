package dam.proy.ticketing.app.automatizacion;

import dam.proy.ticketing.app.models.Ticket;
import dam.proy.ticketing.app.models.enums.EstadoTicket;
import dam.proy.ticketing.app.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketAutoCierreService {

    @Autowired
    private TicketRepository ticketRepository;

    /*Le estamos diciendo que si el ticket ha sido resuelto hace un minuto le cambie el estado al ticket a cerrado.
    * */
    @Scheduled(fixedRate = 60000)
    public void cerrarTicketsResueltos() {

        List<Ticket> ticketsResueltos = ticketRepository.findByEstado(EstadoTicket.RESUELTO);

        for(Ticket item : ticketsResueltos){
            if(item.getFecha_resolucion() != null && item.getFecha_resolucion().isBefore(LocalDateTime.now().minusMinutes(1))){

                item.setEstadoTicket(EstadoTicket.CERRADO);
                item.setFecha_cierre(LocalDateTime.now());
                ticketRepository.save(item);
            }
        }
    }

}
