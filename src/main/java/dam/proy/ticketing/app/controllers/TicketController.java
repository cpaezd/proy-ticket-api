package dam.proy.ticketing.app.controllers;

import dam.proy.ticketing.app.models.Ticket;
import dam.proy.ticketing.app.models.Usuario;
import dam.proy.ticketing.app.models.dto.TicketDTO;
import dam.proy.ticketing.app.services.interfaces.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/ticket")
class TicketController {

    @Autowired
    private ITicketService ticketService;


    // --------- VER TODOS LOS TICKETS QUE NO TIENEN EL ESTADO RESUELTO O CERRADO  -------
    @GetMapping()
    public ResponseEntity<?> verTodosLosTicketActivos (@RequestParam int id_usuario){
        try{
            List<Ticket> tickets = ticketService.verActivosParaAgente(id_usuario);

            if(tickets.isEmpty()){
                return ResponseEntity.ok(Collections.emptyList());
            }
            return ResponseEntity.ok(tickets);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener los tickets para agente: " + e.getMessage());
        }
    }

    //--------- VER TODOS LOS TICKETS CON EL ESTADO RESUELTO O CERRADO  -------
    @GetMapping("/resueltos")
    public ResponseEntity<?> verTicketsResueltos(){
        try{
            List<Ticket> tickets = ticketService.verResueltosCerrados();

            if(tickets.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay tickets");
            }
            return ResponseEntity.ok(tickets);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener los tickets resueltos: " + e.getMessage());
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
    public ResponseEntity<Ticket> editarTicket(@PathVariable int id, @RequestBody Ticket ticket, Principal principal) {
        String emailUsuario = principal.getName(); // ← obtiene el email del usuario autenticado
        Ticket actualizado = ticketService.editarTicket(id, ticket, emailUsuario);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }

    // --------- VER TODOS LOS TICKETS DE UN GRUPO QUE ESTAN ACTIVOS(SIN RESOLVER) -------

    @GetMapping("grupo/{id_grupo}")
    public  ResponseEntity<List<TicketDTO>> verPorGrupo(@PathVariable int id_grupo, @RequestParam int id_usuario){
        return new ResponseEntity<>(ticketService.buscarPorGrupo(id_grupo,id_usuario),HttpStatus.OK);
    }

    // --------- VER TODOS LOS TICKETS DE UN GRUPO QUE ESTAN RESUELTOS O CERRADOS -------
    @GetMapping("grupo/resuelto/{id_grupo}")
    public ResponseEntity<List<TicketDTO>> verPorGrupoResueltos(@PathVariable int id_grupo){
        return new ResponseEntity<>(ticketService.buscarPorGrupoResueltos(id_grupo),HttpStatus.OK);
    }

    // -------------------------------------   WORKSPACE DE AGENTE    -------------------------------------------------

    // --------- ASIGNAR UN TICKET A UN AGENTE PARA QUE SOLO LO PUEDA VISUALIZAR EN SU WORKSPACE -------
    @PutMapping("asignar/{id_ticket}")
    public ResponseEntity<?> asignarTicket(@PathVariable int id_ticket,@RequestParam int id_usuario){
        try{
            Ticket ticket = ticketService.asignarResponsable(id_ticket,id_usuario);
            return ResponseEntity.ok(ticket);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al asignar ticket: " + e.getMessage());
        }
    }
    // --------- DESASIGNAR TICKET PARA QUE VUELVA A QUEDAR LIBRE A LA VISTA DE TODOS LOS AGENTES Y SE PUEDA SOLVENTAR -------

    @PutMapping("desasignar/{id_ticket}")
    public ResponseEntity<?> desasignarTicket(@PathVariable int id_ticket){
        try{
            Ticket ticket= ticketService.designarResponsable(id_ticket);
            return ResponseEntity.ok(ticket);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al desasignar ticket: " + e.getMessage());
        }
    }

    // --------- VER TICKETS ASIGNADOS A UN AGENTE EN SU WORKSPACE -------

    @GetMapping("/workspace")
    public ResponseEntity<?> verTicketsAsignados(@RequestParam int id_usuario){
        try{
            List<Ticket> tickets = ticketService.verTicketAsignadosAgente(id_usuario);
            return ResponseEntity.ok(tickets);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener los tickets asignados: " + e.getMessage());
        }
    }

    // --------- LIBERAR TICKETS ASIGNADOS -------

    @PutMapping("/liberar")
    public ResponseEntity<?> liberarTickets(@RequestParam int id_usuario){
        try{
            ticketService.liberarTickets(id_usuario);
            return ResponseEntity.ok("Tickets liberados correctamente");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al liberar tickets: " + e.getMessage());
        }
    }

    // --------- DROPEAR TICKET QUITARLE LA ASIGNACION POR ID_TICKET -------
    @PutMapping("/dropear")
    public ResponseEntity<String> dropearTicket(@RequestParam int id_ticket){
        boolean resultado = ticketService.dropearTicket(id_ticket);

        if(resultado){
            return ResponseEntity.ok("Ticket dropeado correctamente");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket no encontrado");
        }
    }

    // -------------------------------------   WORKSPACE DE TECNICO   -------------------------------------------------

     // --------- ASIGNAR UN TICKET A UN TECNICO PARA QUE SOLO LO PUEDA VISUALIZAR EN SU WORKSPACE -------

    @PutMapping("asignar/tecnico/{id_ticket}")
    public ResponseEntity<?> asignarTicketTecnico(@PathVariable int id_ticket, @RequestParam int id_usuario){

        try{
            Ticket ticket = ticketService.asignarResponsableTecnico(id_ticket,id_usuario);
            return ResponseEntity.ok(ticket);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al asignar ticket: " + e.getMessage());
        }
    }

    // --------- DESASIGNAR TICKET PARA QUE VUELVA A QUEDAR LIBRE A LA VISTA DE TODOS LOS TECNICOS Y SE PUEDA SOLVENTAR -------
    @PutMapping("desasignar/tecnico/{id_ticket}")
    public ResponseEntity<?> desasignarTicketTecnico(@PathVariable int id_ticket){
        try{
            Ticket ticket= ticketService.desasignarResponsableTecnico(id_ticket);
            return ResponseEntity.ok(ticket);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al desasignar ticket: " + e.getMessage());
        }
    }

    // --------- VER TICKETS ASIGNADOS A UN TECNICO EN SU WORKSPACE -------

    @GetMapping("workspace/tecnico")
    public ResponseEntity<?> verTicketsAsignadosTecnico(@RequestParam int id_usuario){
        try{
            List<Ticket> tickets = ticketService.verTicketsAsignadosTecnico(id_usuario);
            return ResponseEntity.ok(tickets);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener los tickets asignados: " + e.getMessage());
        }

    }
    // --------- LIBERAR TICKETS ASIGNADOS TECNICO-------
    @PutMapping("/liberar/tecnico")
    public ResponseEntity<?> liberarTicketsTecnico (@RequestParam int id_usuario){
        try{
            ticketService.liberarTicketsTecnico(id_usuario);
            return ResponseEntity.ok("Tickets liberados correctamente");

        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al liberar tickets: " + e.getMessage());
        }
    }

    // --------- DROPEAR TICKET QUITARLE LA ASIGNACION POR ID_TICKET AL WORKSPACE DE TECNICO -------
    @PutMapping("/dropear/tecnico")
    public ResponseEntity<String> dropearTicketTecnico(@RequestParam int id_ticket){
        boolean resultado = ticketService.dropearTicketTecnico(id_ticket);

        if(resultado){
            return ResponseEntity.ok("Ticket dropeado correctamente");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket no encontrado");
        }
    }
    // --------- FILTROS ---------------------

    @GetMapping("/asunto")
    public ResponseEntity<List<Ticket>> filtrarPorAsunto(@RequestParam String asunto){
        List<Ticket> tickets = ticketService.buscarPorAsunto(asunto);
        return ResponseEntity.ok(tickets);
    }

    @GetMapping("/fechas")
    public ResponseEntity<List<Ticket>> filtrarPorFechas (@RequestParam LocalDate fechaInicio, @RequestParam LocalDate fechaFin){
        List<Ticket> tickets = ticketService.buscarPorFechaInicioFin(fechaInicio,fechaFin);
        return ResponseEntity.ok(tickets);
    }

}
