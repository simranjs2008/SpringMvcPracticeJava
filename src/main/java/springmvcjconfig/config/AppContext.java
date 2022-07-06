package springmvcjconfig.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:database.properties"})
public class AppContext {

	@Autowired
	Environment environment;
	
	  @Bean
	  public DataSource dataSource() {
	      DriverManagerDataSource dataSource = new DriverManagerDataSource();
	      dataSource.setDriverClassName(environment.getProperty("jdbc.driverClass"));
	      dataSource.setUrl(environment.getProperty("jdbc.url"));
	      dataSource.setUsername(environment.getProperty("jdbc.username"));
	      dataSource.setPassword(environment.getProperty("jdbc.password"));
//	      dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//	      dataSource.setUrl("jdbc:mysql://localhost:3306/learning");
//	      dataSource.setUsername("root");
//	      dataSource.setPassword("root");
	      return dataSource;
	  }
	  
	  @Bean
	  public LocalSessionFactoryBean sessionFactory() {
	      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	      //sessionFactory.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
	      sessionFactory.setDataSource(dataSource());
	      sessionFactory.setPackagesToScan(new String[] {
	          "springmvcjconfig.model"
	      });
	      sessionFactory.setHibernateProperties(hibernateProperties());
	      return sessionFactory;
	  }
	  
		private Properties hibernateProperties() {
			Properties properties = new Properties();
			properties.put("hibernate.dialect",environment.getProperty("hibernate.dialect"));
			properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
			properties.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
			properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
//			properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//			properties.put("hibernate.show_sql", "true");
//			properties.put("hibernate.format_sql", "true");
//			properties.put("hibernate.hbm2ddl.auto", "create");
			return properties;
		}
		
	    @Bean
	    public HibernateTransactionManager getTransactionManager() {
	        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
	        transactionManager.setSessionFactory(sessionFactory().getObject());
	        return transactionManager;
	    }
}
