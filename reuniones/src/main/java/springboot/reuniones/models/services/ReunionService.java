package springboot.reuniones.models.services;

import org.springframework.stereotype.Service;
import springboot.reuniones.data.ReunionRepository;
import springboot.reuniones.models.Persona;
import springboot.reuniones.models.Reunion;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReunionService {

    private final ReunionRepository reunionRepository;

    public ReunionService(ReunionRepository reunionRepository) {
        this.reunionRepository = reunionRepository;
    }

    public List<Reunion> getAllReuniones(){
        return reunionRepository.findAll();
    }
    public Optional <Reunion> getById(long id){
        return reunionRepository.findById(id);
    }
}
