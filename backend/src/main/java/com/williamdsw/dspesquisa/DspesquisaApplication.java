package com.williamdsw.dspesquisa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.config.BootstrapMode;

@SpringBootApplication
public class DspesquisaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DspesquisaApplication.class, args);
	}

}
