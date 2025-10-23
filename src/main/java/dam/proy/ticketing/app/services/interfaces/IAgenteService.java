package dam.proy.ticketing.app.services.interfaces;

import dam.proy.ticketing.app.models.Agente;
import dam.proy.ticketing.app.models.dto.UsuarioDTO;

import java.util.List;

public interface IAgenteService {
    Agente nuevoAgente(Agente agente);
    List<UsuarioDTO> obtenerUsuariosPorGrupo(int id_grupo);

	Agente getAgente(int id);
}
