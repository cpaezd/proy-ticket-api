package dam.proy.ticketing.app.services;

import dam.proy.ticketing.app.repositories.SolicitanteRepository;
import dam.proy.ticketing.app.services.interfaces.ISolicitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitanteService implements ISolicitanteService {

    @Autowired
    private SolicitanteRepository solicitanteRepository;
}
