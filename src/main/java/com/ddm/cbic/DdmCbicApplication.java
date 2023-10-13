package com.ddm.cbic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.builder.SpringApplicationBuilder;

@EnableJpaRepositories
@SpringBootApplication
public class DdmCbicApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DdmCbicApplication.class, args);
	}

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(DdmCbicApplication.class);
    }
}

