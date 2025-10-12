package dam.proy.ticketing.app.repositories;

import dam.proy.ticketing.app.models.Anotacion;
import dam.proy.ticketing.app.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnotacionRepository extends JpaRepository<Anotacion,Integer> {
	List<Anotacion> getAnotacionesByTicket(Ticket ticket);
}
