package dam.proy.ticketing.app.controllers;

import dam.proy.ticketing.app.models.dto.LoginResponseDTO;
import dam.proy.ticketing.app.models.Usuario;
import dam.proy.ticketing.app.services.interfaces.IUsuarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    // ------- VER TODOS LOS USUARIOS
    @GetMapping("/")
    public ResponseEntity<?> getUsuarios()
    {
        return ResponseEntity.ok(this.usuarioService.getUsuarios());
    }

    // -------- VER UN USUARIO POR ID ---------
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable String id)
    {
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario){
        LoginResponseDTO autentificado = usuarioService.autentificar(usuario);

        if(autentificado != null){
            return ResponseEntity.ok(autentificado);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
