package springboot.reuniones.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springboot.reuniones.models.services.ReunionService;

@Component
@Order(2)
public class AgendaRunner implements ApplicationRunner {
    private static final Logger LOG= LoggerFactory.getLogger(
            AgendaRunner.class);

    @Autowired
    private ReunionService reunionService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOG.info("Directorio de reuniones: ");
        reunionService.getAllReuniones().forEach(reunion -> {
            LOG.info(reunion.toString());
        });
        LOG.info("Fin dle directorio");
    }
}
