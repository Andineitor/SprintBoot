package springboot.reuniones.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint (id="personalizado")
public class EndpointPersonalizado {
    @ReadOperation
    public String hetAlgo(){
        return "algo";
    }
}
