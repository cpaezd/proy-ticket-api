package dam.proy.ticketing.app.services;

import dam.proy.ticketing.app.repositories.GrupoRepository;
import dam.proy.ticketing.app.services.interfaces.IGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupoService implements IGrupoService {

    @Autowired
    private GrupoRepository grupoRepository;
}
