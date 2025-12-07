package dam.proy.ticketing.app.services;

import dam.proy.ticketing.app.models.Grupo;
import dam.proy.ticketing.app.models.Solicitante;
import dam.proy.ticketing.app.models.Ticket;
import dam.proy.ticketing.app.models.dto.TicketCreacionDTO;
import dam.proy.ticketing.app.models.enums.EstadoTicket;
import dam.proy.ticketing.app.models.enums.ImpactoTicket;
import dam.proy.ticketing.app.models.enums.UrgenciaTicket;
import dam.proy.ticketing.app.models.enums.PrioridadTicket;
import dam.proy.ticketing.app.repositories.GrupoRepository;
import dam.proy.ticketing.app.repositories.SolicitanteRepository;
import dam.proy.ticketing.app.repositories.TicketRepository;
import dam.proy.ticketing.app.services.interfaces.ISolicitanteService;
import dam.proy.ticketing.app.services.mailing.IMailingService;
import dam.proy.ticketing.app.services.mailing.MailingService;
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
    private GrupoRepository grupoRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private IMailingService mailingService;

    /**
     * Implementación para obtener los tickets.
     * Usa el método que añadimos a TicketRepository.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Ticket> obtenerTicketsPorEmail(String email) {
        // 1. Llama directamente al método que busca por el email del usuario anidado.
        return ticketRepository.findBySolicitante_Usuario_Email(email);
    }

    /**
     * Implementación para crear el ticket.
     */
    @Override
    @Transactional
    public Ticket crearTicket(TicketCreacionDTO ticketDTO, String email) {
        // 1. Buscar al solicitante...
        Solicitante solicitante = solicitanteRepository.findByUsuario_Email(email)
                .orElseThrow(() -> new RuntimeException("Solicitante no encontrado para el email: " + email));

        // 2. Crear el ticket...
        Ticket nuevoTicket = new Ticket();

        // 3. Llenar el ticket con datos:
        nuevoTicket.setAsunto(ticketDTO.getAsunto());
        nuevoTicket.setDescripcion(ticketDTO.getDescripcion());
        nuevoTicket.setSolicitante(solicitante);

        nuevoTicket.setEstadoTicket(EstadoTicket.ABIERTO); // O el que uses

        nuevoTicket.setFechaCreacion(LocalDateTime.now());


        nuevoTicket.setImpacto(ImpactoTicket.BAJO);
        nuevoTicket.setUrgencia(UrgenciaTicket.BAJA);
        nuevoTicket.setPrioridad(PrioridadTicket.BAJA);

        // Añadido para el Email
        Grupo predeterminado = this.grupoRepository.findById(1).get();
        nuevoTicket.setGrupo(predeterminado);

        mailingService.sendNewTicketMail(nuevoTicket);
        mailingService.sendAssignedTicketMail(nuevoTicket);

        // 4. Guardar...
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