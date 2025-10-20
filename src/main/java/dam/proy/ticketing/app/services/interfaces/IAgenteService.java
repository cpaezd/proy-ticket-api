package dam.proy.ticketing.app.services.interfaces;

import dam.proy.ticketing.app.models.dto.UsuarioDTO;

import java.util.List;

public interface IAgenteService {

    public List<UsuarioDTO> obtenerUsuariosPorGrupo(int id_grupo);
}
