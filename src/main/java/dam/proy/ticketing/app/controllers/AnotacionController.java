package dam.proy.ticketing.app.controllers;

import dam.proy.ticketing.app.models.Anotacion;
import dam.proy.ticketing.app.models.Ticket;
import dam.proy.ticketing.app.services.interfaces.IAnotacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/anotacion")
public class AnotacionController {
    @Autowired
    private IAnotacionService anotacionService;

    @GetMapping("/{ticket}")
    public ResponseEntity<?> getAnotacionesByTicket(int ticket) {
        List<Anotacion> anotaciones = anotacionService.getAnotacionesByTicket(new Ticket(ticket));

        if(anotaciones.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(anotaciones);
    }

    // -------- BORRAR UN MENSAJE POR ID ----------
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> borrarAnotacion(@PathVariable int id, Principal principal){
        String email = principal.getName();
        anotacionService.borrarPorId(id, email);
        return ResponseEntity.ok().build();
    }

    // ------- EDITAR UN MENSAJE POR ID --------------------

    @PutMapping("editar/{id}")
    public ResponseEntity<?> editarAnotacion(@PathVariable int id, @RequestBody String nuevaDescripcion, Principal principal){
        String email = principal.getName();
        anotacionService.editarPorId(id,nuevaDescripcion,email);
        return ResponseEntity.ok().build();

    }
}
