package springboot.reuniones.models.services;

import org.springframework.stereotype.Service;
import springboot.reuniones.data.PersonaRepository;
import springboot.reuniones.models.Persona;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> getAllPersona(){
        return personaRepository.findAll();
    }
    public Optional <Persona> getById(long id){
        return personaRepository.findById(id);
    }
}
