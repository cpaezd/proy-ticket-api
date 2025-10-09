package dam.proy.ticketing.app.services;

import dam.proy.ticketing.app.repositories.AgenteRepository;
import dam.proy.ticketing.app.services.interfaces.IAgenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenteService implements IAgenteService {

    @Autowired
    private AgenteRepository agenteRepository;
}
