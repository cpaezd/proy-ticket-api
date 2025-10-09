package dam.proy.ticketing.app.controllers;

import dam.proy.ticketing.app.services.interfaces.IGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grupo")
public class GrupoController {

    @Autowired
    private IGrupoService grupoService;
}
