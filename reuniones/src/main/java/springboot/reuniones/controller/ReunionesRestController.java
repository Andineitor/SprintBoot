package springboot.reuniones.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.reuniones.models.Reunion;
import springboot.reuniones.models.services.ReunionService;

import java.util.List;

@RestController
@RequestMapping("/api/reuniones")
public class ReunionesRestController {
    private ReunionService reunionService;

    public ReunionesRestController(ReunionService reunionService) {
        this.reunionService = reunionService;
    }
    @GetMapping
    public List<Reunion> getAllReuniones(){
        return reunionService.getAllReuniones();
    }
}
