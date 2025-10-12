package dam.proy.ticketing.app.controllers;

import dam.proy.ticketing.app.models.Grupo;
import dam.proy.ticketing.app.services.interfaces.IGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/grupo")
public class GrupoController {

    @Autowired
    private IGrupoService grupoService;


    // --------- VER TODOS LOS TIPOS DE GRUPO QUE HAY -----------------
    @GetMapping("/nombres")
    public ResponseEntity<List<String>> verNombresGrupo(){
        return  new ResponseEntity<>(grupoService.verNombres(), HttpStatus.OK);
    }
}
