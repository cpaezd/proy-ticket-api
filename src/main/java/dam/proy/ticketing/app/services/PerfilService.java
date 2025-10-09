package dam.proy.ticketing.app.services;

import dam.proy.ticketing.app.repositories.PerfilRepository;
import dam.proy.ticketing.app.services.interfaces.IPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilService implements IPerfilService {

    @Autowired
    private PerfilRepository perfilRepository;
}
