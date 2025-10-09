package dam.proy.ticketing.app.controllers;

import dam.proy.ticketing.app.services.interfaces.IPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    private IPerfilService perfilService;
}
