package dam.proy.ticketing.app.services;

import dam.proy.ticketing.app.models.Ticket;
import dam.proy.ticketing.app.models.enums.EstadoTicket;
import dam.proy.ticketing.app.models.dto.TicketDTO;
import dam.proy.ticketing.app.models.dto.UsuarioDTO;
import dam.proy.ticketing.app.repositories.TicketRepository;
import dam.proy.ticketing.app.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService {

    private final UsuarioRepository usuarioRepository;
    private final TicketRepository ticketRepository;

    public AdminService(UsuarioRepository usuarioRepository, TicketRepository ticketRepository) {
        this.usuarioRepository = usuarioRepository;
        this.ticketRepository = ticketRepository;
    }

    // Devuelve usuarios que tengan al menos un ticket abierto
    public List<UsuarioDTO> obtenerUsuariosConTicketsAbiertos() {
        // Busca todos los usuarios con tickets abiertos
        return usuarioRepository.findAll().stream()
                .filter(usuario -> !ticketRepository
                        .findBySolicitante_Usuario_IdAndEstadoTicket(usuario.getId(), EstadoTicket.ABIERTO)
                        .isEmpty()
                )
                .map(usuario -> new UsuarioDTO(
                        usuario.getId(),
                        usuario.getNombre(),
                        usuario.getApellidos(),
                        usuario.getEmail(),
                        (long) ticketRepository
                                .findBySolicitante_Usuario_IdAndEstadoTicket(usuario.getId(), EstadoTicket.ABIERTO)
                                .size()
                ))
                .collect(Collectors.toList());
    }

    //Obtiene tickets de un usuario concreto (solo abiertos)
    public List<TicketDTO> obtenerTicketsPorUsuario(Long usuarioId) {
        List<Ticket> tickets = ticketRepository
                .findBySolicitante_Usuario_IdAndEstadoTicket(usuarioId, EstadoTicket.ABIERTO);

        return tickets.stream()
                .map(t -> new TicketDTO(
                        t.getId(),
                        t.getAsunto(),
                        t.getDescripcion(),
                        t.getEstadoTicket().name()
                ))
                .collect(Collectors.toList());
    }
}
