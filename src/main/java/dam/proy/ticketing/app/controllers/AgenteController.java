package dam.proy.ticketing.app.controllers;

import dam.proy.ticketing.app.services.interfaces.IAgenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agente")
public class AgenteController {

    @Autowired
    private IAgenteService agenteService;
}
