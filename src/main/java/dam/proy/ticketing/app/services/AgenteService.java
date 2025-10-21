package dam.proy.ticketing.app.services;

import dam.proy.ticketing.app.models.Agente;
import dam.proy.ticketing.app.models.Usuario;
import dam.proy.ticketing.app.models.dto.UsuarioDTO;
import dam.proy.ticketing.app.repositories.AgenteRepository;
import dam.proy.ticketing.app.services.interfaces.IAgenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgenteService implements IAgenteService {

    @Autowired
    private AgenteRepository agenteRepository;

    @Override
    public Agente nuevoAgente(Agente agente) {
        return this.agenteRepository.save(agente);
    }

    @Override
    public List<UsuarioDTO> obtenerUsuariosPorGrupo(int id_grupo) {
        List<Agente> agentes = agenteRepository.buscarPorGrupo(id_grupo);
        List<UsuarioDTO> usuarios = new ArrayList<>();

        for(Agente item : agentes){
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.setId((int) item.getUsuario().getId());
            usuarioDTO.setNombre(item.getUsuario().getNombre());

            usuarios.add(usuarioDTO);
        }
        return usuarios;
    }
}
