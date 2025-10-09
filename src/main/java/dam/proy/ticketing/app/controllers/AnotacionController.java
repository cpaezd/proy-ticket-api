package dam.proy.ticketing.app.controllers;

import dam.proy.ticketing.app.services.interfaces.IAnotacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anotacion")
public class AnotacionController {

    @Autowired
    private IAnotacionService anotacionService;
}
