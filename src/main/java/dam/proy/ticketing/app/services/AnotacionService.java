package dam.proy.ticketing.app.services;

import dam.proy.ticketing.app.models.Anotacion;
import dam.proy.ticketing.app.models.Historial;
import dam.proy.ticketing.app.models.Ticket;
import dam.proy.ticketing.app.models.Usuario;
import dam.proy.ticketing.app.repositories.AnotacionRepository;
import dam.proy.ticketing.app.repositories.HistorialRepository;
import dam.proy.ticketing.app.repositories.UsuarioRepository;
import dam.proy.ticketing.app.services.interfaces.IAnotacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnotacionService implements IAnotacionService {
    @Autowired
    private AnotacionRepository anotacionRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    HistorialRepository historialRepository;

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
        Usuario usuario = usuarioRepository.findByEmail(email);

        Historial historial = new Historial();

        historial.setTicket(ticket);
        historial.setUsuario(usuario);
        historial.setFecha(LocalDateTime.now());
        historial.setDetalles("ha borrado una anotacion");
        historialRepository.save(historial);

        anotacionRepository.deleteById(id);


    }
}