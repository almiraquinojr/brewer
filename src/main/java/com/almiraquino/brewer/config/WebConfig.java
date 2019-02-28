package com.almiraquino.brewer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.almiraquino.brewer.controller.BeersController;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
@ComponentScan(basePackageClasses = BeersController.class)
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	private ApplicationContext applicationContext;
	
	@Bean
	public ViewResolver viewResolver() {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		resolver.setCharacterEncoding("UTF-8");
		return resolver;
	}

	@Bean
	public ISpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.setEnableSpringELCompiler(true);
		templateEngine.addDialect(new LayoutDialect());
		return templateEngine;
	}

	
	private ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setApplicationContext(applicationContext);
		templateResolver.setPrefix("/views/");
		templateResolver.setSuffix(".html");
		return templateResolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {		
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
	}

}
