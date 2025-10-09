package dam.proy.ticketing.app.controllers;

import dam.proy.ticketing.app.services.interfaces.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/ticket")
class TicketController {

    @Autowired
    private ITicketService ticketService;

}
