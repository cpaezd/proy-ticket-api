package dam.proy.ticketing.app.services;

import dam.proy.ticketing.app.repositories.UsuarioRepository;
import dam.proy.ticketing.app.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
}
