/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AFPA.CDA03.demo.appliAgence;

/**
 *
 * @author Acer
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/circuits").setViewName("listecircuits");
		registry.addViewController("/").setViewName("listecircuits");
		registry.addViewController("/circuits/ajout").setViewName("ajoutCircuit");
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("/tarifs").setViewName("tarifs");
		registry.addViewController("/inscription").setViewName("inscription");
	}

}

