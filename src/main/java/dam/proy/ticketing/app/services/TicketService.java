package dam.proy.ticketing.app.services;

import dam.proy.ticketing.app.models.Agente;
import dam.proy.ticketing.app.models.Grupo;
import dam.proy.ticketing.app.models.Solicitante;
import dam.proy.ticketing.app.models.Ticket;
import dam.proy.ticketing.app.models.dto.TicketDTO;
import dam.proy.ticketing.app.repositories.AgenteRepository;
import dam.proy.ticketing.app.repositories.GrupoRepository;
import dam.proy.ticketing.app.repositories.SolicitanteRepository;
import dam.proy.ticketing.app.repositories.TicketRepository;
import dam.proy.ticketing.app.services.interfaces.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements ITicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private GrupoRepository grupoRepository;
    @Autowired
    private AgenteRepository agenteRepository;
    @Autowired
    private SolicitanteRepository solicitanteRepository;

    @Override
    public List<Ticket> verTodos() {

       return ticketRepository.findAll();

    }

    @Override
    public TicketDTO buscarPorId(int id) {
        Ticket ticket = ticketRepository.findById(id).orElse(null);

        TicketDTO ticketDTO = new TicketDTO();

        ticketDTO.setId(ticket.getId());
        ticketDTO.setAsunto(ticket.getAsunto());
        ticketDTO.setDescripcion(ticket.getDescripcion());
        ticketDTO.setFechaCreacion(ticket.getFechaCreacion());
        ticketDTO.setEstadoTicket(ticket.getEstadoTicket());
        ticketDTO.setUrgencia(ticket.getUrgencia());
        ticketDTO.setImpacto(ticket.getImpacto());
        ticketDTO.setPrioridad(ticket.getPrioridad());

        if(ticket.getGrupo() != null){
            Grupo grupo = grupoRepository.findById(ticket.getGrupo().getId()).orElse(null);
            if(grupo != null){
                ticketDTO.setGrupo(grupo.getNombre());
            }else {
                ticketDTO.setGrupo(null);
            }
        }

        if(ticket.getAgente() != null){
            Agente agente = agenteRepository.findById(ticket.getAgente().getId()).orElse(null);

            if(agente != null){
                ticketDTO.setTecnico(agente.getUsuario().getNombre());
            }else {
                ticketDTO.setTecnico(null);
            }

        }

        if(ticket.getSolicitante() != null){
            Solicitante solicitante = solicitanteRepository.findById(ticket.getSolicitante().getId()).orElse(null);
            if(solicitante != null){
                ticketDTO.setSolicitante(solicitante.getEmpresa());
            }else {
                ticketDTO.setSolicitante(null);
            }
        }
        ticketDTO.setHistoriales(ticket.getHistoriales());
        ticketDTO.setAnotaciones(ticket.getAnotaciones());

        return ticketDTO;





    }
}
