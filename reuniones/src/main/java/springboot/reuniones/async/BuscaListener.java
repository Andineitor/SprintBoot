package springboot.reuniones.async;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import springboot.reuniones.models.Persona;
import springboot.reuniones.models.Reunion;
import springboot.reuniones.models.services.PersonaService;
import springboot.reuniones.models.services.ReunionService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class BuscaListener {
    private static final Logger LOG= LoggerFactory.getLogger(BuscaListener.class);
    private final ObjectMapper mapper;
    private final PersonaService personaService;
    private final ReunionService reunionService;

    public BuscaListener(ObjectMapper mapper, PersonaService personaService, ReunionService reunionService) {
        this.mapper = mapper;
        this.personaService = personaService;
        this.reunionService = reunionService;
    }
    public void recibirMensaje(String mensaje) {
        try {
            LOG.info("Mensaje recibido: {}", mensaje);  // Imprime el mensaje recibido

            InfoBusca info = mapper.readValue(mensaje, InfoBusca.class);
            long idAsistentes = info.getIdAsistentes();
            long idReuniones = info.getIdReuniones();

            LOG.info("ID Asistente: {}, ID Reunión: {}", idAsistentes, idReuniones);  // Imprime los valores deserializados

            // Procesar el mensaje
            Optional<Persona> persona = personaService.getById(idAsistentes);
            if (persona.isEmpty()){
                LOG.warn("Mensaje recibido, pero la persona {} no exite",
                        info.getIdAsistentes());
            }

            Optional<Reunion> reunion = reunionService.getById(idReuniones);
            if (reunion.isEmpty()) {
                LOG.warn("Mensaje recibido, pero la reunion {} no exite",
                        info.getIdReuniones());
            }
            LOG.info("ID Asistente: {}, ID Reunión: {}", idAsistentes, idReuniones);  // Imprime los valores deserializados
            if (persona.isPresent() && reunion.isPresent()) {
                LOG.info("{} {} tiene una reunión a las {}", persona.get().getNombre(), persona.get().getApellidos(), reunion.get().getFecha());
            }
        } catch (JsonProcessingException e) {
            LOG.warn("Mensaje incorrecto", e);
        } catch (NoSuchElementException e) {
            LOG.error("No se encontró el elemento: {}", e.getMessage(), e);
        } catch (Exception e) {
            LOG.error("Error inesperado al procesar el mensaje: {}", e.getMessage(), e);
        }
    }


}
