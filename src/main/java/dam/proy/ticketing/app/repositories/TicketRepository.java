package dam.proy.ticketing.app.repositories;

import dam.proy.ticketing.app.models.Grupo;
import dam.proy.ticketing.app.models.Ticket;
import dam.proy.ticketing.app.models.enums.EstadoTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// 1. Asegúrate de que el ID del Ticket sea Integer
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    /**
     * Esto busca en Ticket -> Solicitante -> Usuario -> Email
     */
    List<Ticket> findBySolicitante_Usuario_Email(String email);

    //Buscar Tickets por estadoTicket
    @Query("SELECT t FROM Ticket t WHERE t.estadoTicket = :estadoTicket")
    List<Ticket> findByEstado(EstadoTicket estadoTicket);
    //Buscar todos los ticket por grupo
    @Query("SELECT t FROM Ticket t WHERE t.grupo = :id_grupo")
    List<Ticket> findByGrupo(String id_grupo);


}