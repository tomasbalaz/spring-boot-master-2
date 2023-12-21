package sk.balaz.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import sk.balaz.infoapp.InfoApp;

@Configuration
public class CustomerConfig {

    //intellij program arguments --app.useCustomerRepo=false
    @Value("${app.useCustomerRepo:false}")
    private boolean useCustomerRepo;

    @Value("${info.company.name}")
    private String companyName;

    private final Environment environment;

    public CustomerConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    CommandLineRunner commandLineRunner(InfoApp infoApp) {
        return args -> {
            System.out.println("Command line runner");
            System.out.println(companyName);
            System.out.println(environment.getProperty("info.app.version"));
            System.out.println(infoApp);
        };
    }

    @Bean
    CustomerRepo customerRepo() {
        System.out.println("useCustomerRepo = " +  useCustomerRepo);
        return new CustomerFakeRepo();
    }
}
