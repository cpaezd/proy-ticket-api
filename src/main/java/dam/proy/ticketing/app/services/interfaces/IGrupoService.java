package dam.proy.ticketing.app.services.interfaces;

import dam.proy.ticketing.app.models.Grupo;
import dam.proy.ticketing.app.models.dto.GrupoResponseDTO;

import java.util.List;

public interface IGrupoService {

    public List<GrupoResponseDTO> verGrupos();
}
