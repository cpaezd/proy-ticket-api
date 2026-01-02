package dam.proy.ticketing.app.services;

import dam.proy.ticketing.app.models.Anotacion;
import dam.proy.ticketing.app.models.Historial;
import dam.proy.ticketing.app.models.Ticket;
import dam.proy.ticketing.app.models.Usuario;
import dam.proy.ticketing.app.models.enums.EstadoTicket;
import dam.proy.ticketing.app.repositories.AnotacionRepository;
import dam.proy.ticketing.app.repositories.HistorialRepository;
import dam.proy.ticketing.app.repositories.TicketRepository;
import dam.proy.ticketing.app.repositories.UsuarioRepository;
import dam.proy.ticketing.app.services.interfaces.IAnotacionService;
import dam.proy.ticketing.app.services.mailing.IMailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnotacionService implements IAnotacionService {
    @Autowired
    private AnotacionRepository anotacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private HistorialRepository historialRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Anotacion> getAnotacionesByTicket(Ticket ticket) {
       return this.anotacionRepository.getAnotacionesByTicket(ticket);
    }

    @Override
    public void borrarPorId(int id, String email) {
        Anotacion anotacion = anotacionRepository.findById(id).orElse(null);

        if(anotacion == null){
            return;
        }

        Ticket ticket = anotacion.getTicket();
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con email: " + email));

        Historial historial = new Historial();

        historial.setTicket(ticket);
        historial.setUsuario(usuario);
        historial.setFecha(LocalDateTime.now());
        historial.setDetalles("ha borrado una anotacion");
        historialRepository.save(historial);

        anotacionRepository.deleteById(id);


    }

    @Override
    public void editarPorId(int id, String nuevaDescripcion,String email) {

        Anotacion anotacion = anotacionRepository.findById(id).orElse(null);

        if(anotacion == null){
            return;
        }

        anotacion.setDescripcion(nuevaDescripcion);
        anotacion.setFecha(LocalDateTime.now());
        anotacionRepository.save(anotacion);

        Ticket ticket = anotacion.getTicket();
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con email: " + email));

        Historial historial = new Historial();
        historial.setTicket(ticket);
        historial.setUsuario(usuario);
        historial.setFecha(LocalDateTime.now());
        historial.setDetalles("ha editado un mensaje");
        historialRepository.save(historial);
    }

    @Override
    public void crearAnotacion(Anotacion anotacion, String email) {

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con email: " + email));
        Ticket ticket = ticketRepository.findById(anotacion.getTicket().getId()).orElse(null);

        //Aqui le decimos que si ese ticket no tiene un tecnico asignado no se pueda crear un mensaje privado no tendria sentido no iria a ningun lado ese mensaje.
        if (anotacion.getVisibilidadTicket() == 0 && ticket.getGrupo() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se puede crear una anotación privada sin grupo asignado");
        }


        anotacion.setUsuario(usuario);
        anotacion.setTicket(ticket);
        anotacion.setFecha(LocalDateTime.now());


        anotacionRepository.save(anotacion);

        //this.mailingService.sendNewAnnotationMail(anotacion);

        //Aqui le digo que si ticket esta abierto y un agente escribe una anotacion en ese ticket cambie su estado de Abierto a Pendiente.
        if(usuario.getPerfil().getNombre().equalsIgnoreCase("AGENTE") && ticket.getEstadoTicket() == EstadoTicket.ABIERTO){
            ticket.setEstadoTicket(EstadoTicket.PENDIENTE);
            ticketRepository.save(ticket);
        }

        Historial historial = new Historial();
        historial.setTicket(ticket);
        historial.setUsuario(usuario);
        historial.setFecha(LocalDateTime.now());
        historial.setDetalles("ha escrito un mensaje");

        historialRepository.save(historial);


    }


}