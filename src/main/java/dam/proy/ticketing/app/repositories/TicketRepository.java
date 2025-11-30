package dam.proy.ticketing.app.repositories;

import dam.proy.ticketing.app.models.Grupo;
import dam.proy.ticketing.app.models.Ticket;
import dam.proy.ticketing.app.models.enums.EstadoTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDateTime;
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
    //Buscar tickets que no tengan responsable o que el responsable sea el logeado.
    @Query("SELECT t FROM Ticket t WHERE t.responsable IS NULL OR t.responsable = :id_usuario")
    List<Ticket> verActivosParaAgente(int id_usuario);
    //Buscar los tickets en los que el responsable sea el agente logeado
    @Query("SELECT t FROM Ticket t WHERE t.responsable = :id_usuario")
    List<Ticket> verTicketsAsignados(int id_usuario);
    //Buscar los tickets en los que el responsable sea el tecnico logeado
    @Query("SELECT t FROM Ticket t WHERE t.responsable_tecnico = :id_usuario")
    List<Ticket> verTicketsAsignadosTecnico(int id_usuario);

    // -----------------   FILTROS -------------------

    @Query("SELECT t FROM Ticket t WHERE t.asunto LIKE CONCAT(:asunto, '%')")
    List<Ticket> obtenerTicketsPorAsunto(String asunto);

    @Query("SELECT t FROM Ticket t WHERE t.fechaCreacion BETWEEN :fechaInicio AND :fechaFin")
    List<Ticket> obtenerTicketsPorFechaInicioYFin(LocalDateTime fechaInicio, LocalDateTime fechaFin);




}