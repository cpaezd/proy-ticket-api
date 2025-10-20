package dam.proy.ticketing.app.services;

import dam.proy.ticketing.app.models.Grupo;
import dam.proy.ticketing.app.models.dto.GrupoResponseDTO;
import dam.proy.ticketing.app.repositories.GrupoRepository;
import dam.proy.ticketing.app.services.interfaces.IGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GrupoService implements IGrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    @Override
    public List<GrupoResponseDTO> verGrupos() {
       List<Grupo> grupos =  grupoRepository.findAll();
       List<GrupoResponseDTO> respuesta = new ArrayList<>();

       for(Grupo item: grupos){
           GrupoResponseDTO grupoResponseDTO = new GrupoResponseDTO();

           grupoResponseDTO.setId(item.getId());
           grupoResponseDTO.setNombre(item.getNombre());

           respuesta.add(grupoResponseDTO);
       }


       return respuesta;
    }
}

