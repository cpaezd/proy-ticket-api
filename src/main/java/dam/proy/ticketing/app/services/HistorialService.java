package dam.proy.ticketing.app.services;

import dam.proy.ticketing.app.repositories.HistorialRepository;
import dam.proy.ticketing.app.services.interfaces.IHistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistorialService implements IHistorialService {

    @Autowired
    private HistorialRepository historialRepository;


}
