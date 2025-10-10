package dam.proy.ticketing.app.controllers;

import dam.proy.ticketing.app.dto.LoginRespuestaDTO;
import dam.proy.ticketing.app.models.Usuario;
import dam.proy.ticketing.app.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/usuario")
class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario usuario){
        LoginRespuestaDTO autentificado = usuarioService.autentificar(usuario);

        if(autentificado != null){
            return ResponseEntity.ok(autentificado);
        }else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
