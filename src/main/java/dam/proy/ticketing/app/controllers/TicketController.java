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


    // --------- VER TODOS LOS TICKETS EXCEPTO LOS CERRADOS -------
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

    // ------- VER UN TICKET ----------

    @GetMapping("{id}")
    public ResponseEntity<?> verUnTicket(@PathVariable int id){
        try{
            Ticket ticket = ticketService.buscarPorId(id);

            if(ticket == null){
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket no encontrado");
            }
            return ResponseEntity.ok(ticket);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener el ticket" + e.getMessage());
        }
    }


}
