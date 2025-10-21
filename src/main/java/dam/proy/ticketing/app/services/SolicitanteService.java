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

    @Override
    public Solicitante nuevoSolicitante(Solicitante solicitante) {
        return this.solicitanteRepository.save(solicitante);
    }
}