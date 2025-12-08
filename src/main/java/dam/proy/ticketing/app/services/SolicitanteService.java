package dam.proy.ticketing.app.services;

import dam.proy.ticketing.app.models.Solicitante;
import dam.proy.ticketing.app.models.Ticket;
import dam.proy.ticketing.app.models.dto.TicketCreacionDTO;
import dam.proy.ticketing.app.models.enums.EstadoTicket;
import dam.proy.ticketing.app.models.enums.ImpactoTicket;
import dam.proy.ticketing.app.models.enums.UrgenciaTicket;
import dam.proy.ticketing.app.models.enums.PrioridadTicket;
import dam.proy.ticketing.app.repositories.SolicitanteRepository;
import dam.proy.ticketing.app.repositories.TicketRepository;
import dam.proy.ticketing.app.services.interfaces.ISolicitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SolicitanteService implements ISolicitanteService {

    @Autowired
    private SolicitanteRepository solicitanteRepository;

    @Autowired
    private TicketRepository ticketRepository;

    // --- MÉTODOS DE FILTRADO Y VISUALIZACIÓN ---

    // EL MÉTODO obtenerTicketsPorEmail HA SIDO ELIMINADO PARA RESOLVER EL ERROR DE COMPILACIÓN.

    /**
     * Implementación para obtener tickets filtrados opcionalmente por estado.
     * Este método ya maneja el caso de no filtro (estado=todos/null).
     */
    @Override
    @Transactional(readOnly = true)
    public List<Ticket> obtenerTicketsPorEmailYEstado(String email, String estado) {

        // 1. Normalizar el filtro (si es "todos" o nulo, lo tratamos como sin filtro)
        boolean sinFiltroDeEstado = estado == null || estado.trim().isEmpty() || estado.equalsIgnoreCase("todos");

        if (sinFiltroDeEstado) {
            // Si no hay filtro, usamos el método que trae todos
            return ticketRepository.findBySolicitante_Usuario_Email(email);
        } else {
            try {
                // 2. CONVERTIR el String del filtro al ENUM:
                EstadoTicket estadoFiltro = EstadoTicket.valueOf(estado.toUpperCase());

                // 3. Si hay un estado válido, usamos el método de filtrado por ENUM.
                return ticketRepository.findBySolicitante_Usuario_EmailAndEstadoTicket(email, estadoFiltro);
            } catch (IllegalArgumentException e) {
                // Manejar el caso si el String 'estado' no coincide con ningún valor del ENUM
                System.err.println("Error de filtro: Estado '" + estado + "' no es un valor de EstadoTicket válido.");
                return ticketRepository.findBySolicitante_Usuario_Email(email); // Devolver todos o lista vacía
            }
        }
    }

    // --- MÉTODOS DE CREACIÓN Y ACTUALIZACIÓN ---

    /**
     * Implementación para crear el ticket.
     */
    @Override
    @Transactional
    public Ticket crearTicket(TicketCreacionDTO ticketDTO, String email) {
        // 1. Buscar al solicitante
        Solicitante solicitante = solicitanteRepository.findByUsuario_Email(email)
                .orElseThrow(() -> new RuntimeException("Solicitante no encontrado para el email: " + email));

        // 2. Crear el ticket
        Ticket nuevoTicket = new Ticket();

        // 3. Llenar el ticket con datos
        nuevoTicket.setAsunto(ticketDTO.getAsunto());
        nuevoTicket.setDescripcion(ticketDTO.getDescripcion());
        nuevoTicket.setSolicitante(solicitante);
        nuevoTicket.setEstadoTicket(EstadoTicket.ABIERTO);
        nuevoTicket.setFechaCreacion(LocalDateTime.now());
        nuevoTicket.setImpacto(ImpactoTicket.BAJO);
        nuevoTicket.setUrgencia(UrgenciaTicket.BAJA);
        nuevoTicket.setPrioridad(PrioridadTicket.BAJA);

        // 4. Guardar
        return ticketRepository.save(nuevoTicket);
    }

    @Override
    public Solicitante nuevoSolicitante(Solicitante solicitante) {
        return this.solicitanteRepository.save(solicitante);
    }

    @Override
    public Solicitante getSolicitante(int id) {
        return this.solicitanteRepository.findById(id).orElse(null);
    }

    @Override
    public Solicitante updateSolicitante(Solicitante solicitante) {
        return this.solicitanteRepository.save(solicitante);
    }
}