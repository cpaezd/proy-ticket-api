package dam.proy.ticketing.app.controllers;

import dam.proy.ticketing.app.models.dto.TicketCreacionDTO;
import dam.proy.ticketing.app.services.interfaces.ISolicitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/solicitante")
public class SolicitanteController {

    @Autowired
    private ISolicitanteService solicitanteService;

    /**
     * Endpoint para que un solicitante obtenga todos sus tickets.
     * Utiliza el objeto Authentication para identificar al usuario logueado.
     */
    @GetMapping("/tickets")
    public ResponseEntity<?> obtenerTicketsDelSolicitante(Authentication authentication) {

        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no autenticado.");
        }

        try {

            String emailUsuario = authentication.getName();
            var tickets = solicitanteService.obtenerTicketsPorEmail(emailUsuario);
            return ResponseEntity.ok(tickets);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener los tickets: " + e.getMessage());
        }
    }

    /**
     * Endpoint para que un solicitante cree un nuevo ticket.
     * Recibe los datos del ticket en el cuerpo de la petición.
     */
    @PostMapping("/tickets")
    public ResponseEntity<?> crearTicket(@RequestBody TicketCreacionDTO ticketDTO, Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario no autenticado.");
        }

        try {
            String emailUsuario = authentication.getName();
            var nuevoTicket = solicitanteService.crearTicket(ticketDTO, emailUsuario);

            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTicket);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el ticket: " + e.getMessage());
        }
    }
}