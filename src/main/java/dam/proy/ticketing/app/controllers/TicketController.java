package dam.proy.ticketing.app.controllers;

import dam.proy.ticketing.app.models.Ticket;
import dam.proy.ticketing.app.services.interfaces.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/ticket")
class TicketController {
    @Autowired
    private ITicketService ticketService;

    // --------- VER TODOS LOS TICKETS -------
    @GetMapping()
    public ResponseEntity<?> verTodosLosTicket (){
        try{
            List<Ticket> tickets = ticketService.verTodos();

            if(tickets.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay tickets");
            }
            return ResponseEntity.ok(tickets);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener los tickets para agente: " + e.getMessage());
        }
    }

    @GetMapping("/{ticket}/anotaciones")
    public ResponseEntity<?> getAnotacionesByTicket(@PathVariable String ticket){
        return null;
    }
}
