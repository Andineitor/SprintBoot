package springboot.reuniones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import springboot.reuniones.models.Persona;
import springboot.reuniones.models.Reunion;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springboot.reuniones.models.services.ReunionService;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/reuniones")
public class ReunionController {
    @Autowired
    private ReunionService reunionService;

    @GetMapping
    public String getAllReuniones(Model model){
        model.addAttribute("reuniones", reunionService.getAllReuniones());
        return "reuniones";
    }
}
