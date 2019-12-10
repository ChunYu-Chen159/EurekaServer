package EurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import com.soselab.vmamveurekaclient.annotation.EnableVmamvRegister;

@SpringBootApplication
@EnableEurekaServer
@EnableVmamvRegister
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}
