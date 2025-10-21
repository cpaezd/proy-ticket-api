package dam.proy.ticketing.app.services;

import dam.proy.ticketing.app.models.*;
import dam.proy.ticketing.app.models.dto.TicketDTO;
import dam.proy.ticketing.app.models.enums.EstadoTicket;
import dam.proy.ticketing.app.repositories.*;
import dam.proy.ticketing.app.services.interfaces.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private HistorialRepository historialRepository;

    @Override
    public List<Ticket> verActivos() {

        List<Ticket> todos = ticketRepository.findAll();
        List<Ticket> activos = new ArrayList<>();

        for(Ticket item : todos){

            if(item.getEstadoTicket() != EstadoTicket.RESUELTO && item.getEstadoTicket() != EstadoTicket.CERRADO){
                activos.add(item);
            }
        }
        return activos;
    }

    @Override
    public List<Ticket> verResueltosCerrados() {
        List<Ticket> todos = ticketRepository.findAll();
        List<Ticket> resueltos = new ArrayList<>();

        for(Ticket item : todos){
            if(item.getEstadoTicket() == EstadoTicket.RESUELTO || item.getEstadoTicket() == EstadoTicket.CERRADO){
                resueltos.add(item);
            }
        }
        return resueltos;
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
                ticketDTO.setId_grupo(grupo.getId());
            }else {
                ticketDTO.setGrupo(null);
            }
        }
        if(ticket.getAgente() != null){
            Agente agente = agenteRepository.findById(ticket.getAgente().getId()).orElse(null);

            if(agente != null){
                ticketDTO.setId_tecnico((int) agente.getUsuario().getId());
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

    @Override
    public Ticket editarTicket(int id, Ticket ticket, String email) {
        Ticket ticket1 = ticketRepository.findById(id).orElse(null);

        if(ticket.getAsunto() != null){
            ticket1.setAsunto(ticket.getAsunto());
        }

        if(ticket.getDescripcion() != null){
            ticket1.setDescripcion(ticket.getDescripcion());
        }

        if(ticket.getFechaCreacion() != null){
            ticket1.setFechaCreacion(ticket.getFechaCreacion());
        }

        if(ticket.getEstadoTicket() != null){
            ticket1.setEstadoTicket(ticket.getEstadoTicket());

            if(ticket.getEstadoTicket() == EstadoTicket.RESUELTO){
                ticket1.setFecha_resolucion(LocalDateTime.now());
            }
        }



        if(ticket.getUrgencia() != null){
            ticket1.setUrgencia(ticket.getUrgencia());
        }

        if(ticket.getImpacto() != null){
            ticket1.setImpacto(ticket.getImpacto());
        }
        if(ticket.getPrioridad() != null){
            ticket1.setPrioridad(ticket.getPrioridad());
        }

        if (ticket.getGrupo() != null && ticket.getGrupo().getNombre() != null) {
            Grupo nuevoGrupo = grupoRepository.findByNombre(ticket.getGrupo().getNombre());
            if (nuevoGrupo != null) {
                ticket1.setGrupo(nuevoGrupo);
            }
        }
        if(ticket.getAgente() != null && ticket.getAgente().getId() != 0){
            Agente agente = agenteRepository.findByUsuario_Id(ticket.getAgente().getId());

            if(agente != null){
                ticket1.setAgente(agente);
            }

        }
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con email: " + email));
        Historial historial = new Historial();
        historial.setTicket(ticket1);
        historial.setFecha(LocalDateTime.now());
        historial.setDetalles("Ha editado el ticket");
        historial.setUsuario(usuario);
        historialRepository.save(historial);
        return ticketRepository.save(ticket1);
    }




}
