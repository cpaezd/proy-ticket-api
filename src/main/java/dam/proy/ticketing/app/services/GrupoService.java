package dam.proy.ticketing.app.services;

import dam.proy.ticketing.app.models.Grupo;
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
    public List<String> verNombres() {
       List<Grupo> grupos =  grupoRepository.findAll();
       List<String> nombreGrupos = new ArrayList<>();

       for(Grupo item: grupos){
           item.getNombre();
           nombreGrupos.add(item.getNombre());
       }

       return nombreGrupos;
    }
}

