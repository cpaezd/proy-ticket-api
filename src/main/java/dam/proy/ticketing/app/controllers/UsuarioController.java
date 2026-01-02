package dam.proy.ticketing.app.controllers;

import dam.proy.ticketing.app.models.dto.*;
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
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable int id)
    {
        UsuarioDTO usuario = this.usuarioService.getUsuario(id);

        return usuario != null
            ? ResponseEntity.ok(usuario)
            : ResponseEntity.notFound().build();
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> nuevoUsuario(@RequestBody NuevoUsuarioRequest nur)
    {
        return this.usuarioService.nuevoUsuario(nur)
            ? ResponseEntity.ok().build()
            : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
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

    @PutMapping("/{id}/editar")
    public ResponseEntity<?> editarUsuario(@PathVariable int id, @RequestBody EditUsuarioRequest eur)
    {
        this.usuarioService.editarUsuario(id, eur);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/estado")
    public ResponseEntity<?> cambiarEstadoUsuario(@PathVariable Integer id)
    {
        this.usuarioService.cambiarEstadoUsuario(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/request-reset/{email}")
    public ResponseEntity<?> requestResetPassword(@PathVariable String email)
    {
        return this.usuarioService.requestResetPassword(email)
            ?  ResponseEntity.ok().build()
            : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody ChangePasswordRequest changePasswordRequest)
    {
        return this.usuarioService.changePassword(changePasswordRequest)
            ? ResponseEntity.ok().build()
            : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
