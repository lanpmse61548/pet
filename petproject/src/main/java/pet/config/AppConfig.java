package pet.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import pet.config.core.SpringSecurityInitializer;
import pet.dao.IDishesDAO;
import pet.service.DishesService;
import pet.web.controller.JSONController;

@EnableWebMvc
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = {IDishesDAO.class})
//@ComponentScan({ "pet.*"})
@ComponentScan(basePackageClasses = { AppConfig.class, DishesService.class, JSONController.class,IDishesDAO.class })
@Import({ SecurityConfig.class })
@PropertySource(value = { "classpath:application.properties" })

public class AppConfig extends WebMvcConfigurerAdapter{

//	@Autowired
//    private Environment environment;
//	@Bean
//	public InternalResourceViewResolver viewResolver() {
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setViewClass(JstlView.class);
//		viewResolver.setPrefix("/WEB-INF/pages/");
//		viewResolver.setSuffix(".jsp");
//		return viewResolver;
//	}
	

	
//	@Bean(name = "dataSource")
//	public DriverManagerDataSource dataSource() {
//	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
//	    driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
//	    driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/petdatabase");
//	    driverManagerDataSource.setUsername("root");
//	    driverManagerDataSource.setPassword("123456");
//	    return driverManagerDataSource;
//	}
	
	
//	 @Bean
//	    public DataSource dataSource() {
//	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
//	        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
//	        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
//	        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
//	        return dataSource;
//	    }

	
//	   @Bean
//	    public ViewResolver viewResolver() {
//	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//	        viewResolver.setViewClass(JstlView.class);
//	        viewResolver.setPrefix("/WEB-INF/pages/");
//	        viewResolver.setSuffix(".jsp");
//	        return viewResolver;
//	    }
	
//	 @Bean
//	 public IDishesDAO dao(){
//		 
//		 return null;
//	 }
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		registry.viewResolver(viewResolver);
	}
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	
	
	  @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	    }
}