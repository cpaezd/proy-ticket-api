package dam.proy.ticketing.app.controllers;

import dam.proy.ticketing.app.models.Anotacion;
import dam.proy.ticketing.app.models.Ticket;
import dam.proy.ticketing.app.services.interfaces.IAnotacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
