package dam.proy.ticketing.app.controllers;

import dam.proy.ticketing.app.models.dto.UsuarioDTO;
import dam.proy.ticketing.app.models.dto.TicketDTO;
import dam.proy.ticketing.app.services.AdminService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:3000") // Ajusta si React corre en otro puerto
public class AdminController {

//    private final AdminService adminService;
//
//    public AdminController(AdminService adminService) {
//        this.adminService = adminService;
//    }
//
//    // Endpoint para obtener usuarios con tickets abiertos
//    @GetMapping("/usuarios-con-tickets")
//    public List<UsuarioDTO> getUsuariosConTickets() {
//        return adminService.obtenerUsuariosConTicketsAbiertos();
//    }
//
//    // Endpoint para obtener tickets de un usuario concreto
//    @GetMapping("/usuarios/{id}/tickets")
//    public List<TicketDTO> getTicketsPorUsuario(@PathVariable Long id) {
//        return adminService.obtenerTicketsPorUsuario(id);
//    }
}
