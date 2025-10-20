package dam.proy.ticketing.app.controllers;

import dam.proy.ticketing.app.models.dto.UsuarioDTO;
import dam.proy.ticketing.app.services.interfaces.IAgenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agente")
public class AgenteController {
    @Autowired
    private IAgenteService agenteService;

    @GetMapping("/grupo/{id}")
    public ResponseEntity<List<UsuarioDTO>> obtenerUsuariosPorGrupo(@PathVariable int id){
        List<UsuarioDTO> usuarios = agenteService.obtenerUsuariosPorGrupo(id);
        return ResponseEntity.ok(usuarios);
    }
}
