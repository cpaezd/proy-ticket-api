package dam.proy.ticketing.app.services;

import dam.proy.ticketing.app.repositories.AnotacionRepository;
import dam.proy.ticketing.app.services.interfaces.IAnotacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnotacionService implements IAnotacionService {

    @Autowired
    private AnotacionRepository anotacionRepository;
}
