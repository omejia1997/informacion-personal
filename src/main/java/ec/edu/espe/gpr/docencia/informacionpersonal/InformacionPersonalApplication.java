package ec.edu.espe.gpr.docencia.informacionpersonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class InformacionPersonalApplication {

	public static void main(String[] args) {
		SpringApplication.run(InformacionPersonalApplication.class, args);
	}

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Guayaquil"));
	}
}
