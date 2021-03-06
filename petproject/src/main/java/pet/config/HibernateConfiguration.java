package pet.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import pet.dao.IDishesDAO;
import pet.dom.Tour;
import pet.service.DishesService;
import pet.web.controller.JSONController;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = {IDishesDAO.class})
@ComponentScan(basePackageClasses = { AppConfig.class, DishesService.class, JSONController.class,IDishesDAO.class })
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {

    @Autowired
    private Environment environment;

    // Declare a JPA entityManagerFactory
	@Bean 
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		
		emf.setDataSource(dataSource());
		//{classpath*:META-INF/persistence.xml} sh*t happen
		emf.setPackagesToScan("pet.dao");
		HibernateJpaVendorAdapter vendor = new HibernateJpaVendorAdapter();
		 vendor.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
		emf.setJpaVendorAdapter(vendor);
		
		return emf;
	}
	
	// Declare a transaction manager
	@Bean 
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }
    
    

  @Bean
  public LocalSessionFactoryBean sessionFactory() {
      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
      sessionFactory.setDataSource(dataSource());
      sessionFactory.setPackagesToScan(new String[] { "pet.*" });
      sessionFactory.setHibernateProperties(hibernateProperties());
    //  sessionFactory.setAnnotatedClasses(Tour.class);
      return sessionFactory;
   }
    
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        return properties;        
    }
    
	@Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(s);
       return txManager;
    }
}

