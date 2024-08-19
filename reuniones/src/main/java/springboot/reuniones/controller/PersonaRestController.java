package springboot.reuniones.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.reuniones.models.Persona;
import springboot.reuniones.models.services.PersonaService;
import springboot.reuniones.models.services.ReunionService;

import java.util.List;

@RestController
@RequestMapping("api/personas")

public class PersonaRestController {
    private PersonaService personaService;

    public PersonaRestController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public List<Persona> getAllPersona(){
        return personaService.getAllPersona();
    }
}
