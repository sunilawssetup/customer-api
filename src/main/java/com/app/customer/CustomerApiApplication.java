package com.app.customer;

import com.app.customer.audit.AuditAwareImpl;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableFeignClients(basePackages = "com.app.customer.service.client")
@OpenAPIDefinition(
        info = @Info(
                title = "CUSTOMER-API",
                description = "this is customer to register and make order",
                version = "V1",
                contact = @Contact(
                        name = "Sunil Mane",
                        email = "manesunil069@gmail.com",
                        url = "/customer/**"

                ),

				license = @License(
				name = "Apache 2.0",
				url = "www.swiggy.com"
		)


        ),
		externalDocs = @ExternalDocumentation(
				url = "www.localhost:9091/swagger-ui/index.html",
				description = "Swagger Api documention"

		)

)
public class CustomerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApiApplication.class, args);
    }

}
