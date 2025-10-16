package dam.proy.ticketing.app.controllers;

import dam.proy.ticketing.app.services.interfaces.IHistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/historial")
public class HistorialController {

    @Autowired
    private IHistorialService historialService;


}
