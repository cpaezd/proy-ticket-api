package dam.proy.ticketing.app.controllers;

import dam.proy.ticketing.app.models.Ticket;
import dam.proy.ticketing.app.models.dto.TicketDTO;
import dam.proy.ticketing.app.services.interfaces.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // ---------- VER TICKET POR ID ----------

    @GetMapping("{id}")
    public ResponseEntity<TicketDTO> verTicketPorId(@PathVariable int id){
        TicketDTO ticketDTO = ticketService.buscarPorId(id);
        return ResponseEntity.ok(ticketDTO);
    }

    // -------------  EDITAR TICKET -------

    @PutMapping("/editar/{id}")
    public ResponseEntity<Ticket> editarTicket(@PathVariable int id, @RequestBody Ticket ticket){
        return (new ResponseEntity<Ticket>(ticketService.editarTicket(id,ticket),HttpStatus.OK));
    }
}
