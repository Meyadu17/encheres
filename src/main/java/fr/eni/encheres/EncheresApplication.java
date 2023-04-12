package fr.eni.encheres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.persistence.EntityManagerFactory;
import java.util.Locale;


@EnableJpaRepositories("fr.eni.encheres.*")
@EnableTransactionManagement
@EntityScan("fr.eni.encheres.*")
@SpringBootApplication
public class EncheresApplication {

	public static void main(String[] args) {
		SpringApplication.run(EncheresApplication.class, args);
	}
/*
	@Bean
	public SessionLocaleResolver localeResolver() {
		SessionLocaleResolver r = new SessionLocaleResolver();
		r.setDefaultLocale(Locale.FRANCE);
		return r;
	}*/
}
