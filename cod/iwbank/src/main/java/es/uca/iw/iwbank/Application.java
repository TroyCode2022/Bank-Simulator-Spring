package es.uca.iw.iwbank;

import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import es.uca.iw.iwbank.data.entity.BankAccount;
import es.uca.iw.iwbank.data.entity.Persona;
import es.uca.iw.iwbank.data.repository.BankAccountRepository;
import es.uca.iw.iwbank.data.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */

@SpringBootApplication
@EnableJpaRepositories
@Theme(value = "iwbank")
@PWA(name = "iwBank", shortName = "iwBank", offlineResources = {})
@NpmPackage(value = "line-awesome", version = "1.3.0")
@NpmPackage(value = "@vaadin-component-factory/vcf-nav", version = "1.0.6")
public class Application implements AppShellConfigurator {
    public static String paymentEndpointURL;
    public static String transactionEndpointURL;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public RestTemplate restTemplate(final RestTemplateBuilder builder) {
        return builder.build();
    }

    static {
        Application.paymentEndpointURL = "http://localhost:8081/api/payments";
        Application.transactionEndpointURL = "http://localhost:8081/api/transactions";
    }
}
