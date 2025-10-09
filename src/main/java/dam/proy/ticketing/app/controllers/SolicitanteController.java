package dam.proy.ticketing.app.controllers;

import dam.proy.ticketing.app.services.interfaces.ISolicitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/solicitante")
public class SolicitanteController {

    @Autowired
    private ISolicitanteService solicitanteService;
}
