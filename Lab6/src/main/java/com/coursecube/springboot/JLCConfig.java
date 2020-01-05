package com.coursecube.springboot;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

/*@Configuration
@ComponentScan(basePackages = {"com.coursecube.springboot"})
*/
/*@Configuration
@ComponentScan(basePackages = {"com.coursecube.springboot"})
@EnableAutoConfiguration*/
@SpringBootApplication
public class JLCConfig {

	@Bean(name = "jlcDataSource")
	public DataSource dataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		//	ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		ds.setUrl("jdbc:mysql://localhost:3306/jlcdb");
		ds.setUsername("root");
		ds.setPassword("bangalore");
		
		return ds;
	}

	@Bean(name = "jlcSessionFactory")
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {

		LocalSessionFactoryBean lsFactory = new LocalSessionFactoryBean();
		lsFactory.setDataSource(dataSource);
		
		Properties probs = new Properties();
		probs.put("hibernate.show_sql", "true");
		probs.put("hibernate.format_sql", "true");
		probs.put("hibernate.hbm2dll.auto", "create");
		probs.put("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
		lsFactory.setHibernateProperties(probs);
		lsFactory.setPackagesToScan("com.coursecube.springboot");
		return lsFactory;
	}

	@Bean(name="jlcHibernateTemplate")
	public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {
		return new HibernateTemplate(sessionFactory);

	}

	@Bean(name = "jlcHibernateTransactionManager")
	public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}

}
