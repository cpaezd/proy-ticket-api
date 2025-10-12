package dam.proy.ticketing.app.services.interfaces;

import dam.proy.ticketing.app.models.Anotacion;
import dam.proy.ticketing.app.models.Ticket;

import java.util.List;

public interface IAnotacionService {
	List<Anotacion> getAnotacionesByTicket(Ticket ticket);
}
