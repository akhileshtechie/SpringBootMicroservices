package com.coursecube.springboot;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class JLCConfig {

	@Bean(name = "jlcDS")
	public DataSource dataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/mydb");
		ds.setUsername("root");
		ds.setPassword("bangalore");
		
		return ds;
	}

	@Bean(name = "jlcVendorAdaptor")
	public JpaVendorAdapter hibJpavendorAdaptor() {

		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");

		return adapter;
	}

	@Bean(name = "jlcEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource ds,
			JpaVendorAdapter jpaVendorAdapter) {

		LocalContainerEntityManagerFactoryBean emFactory = new LocalContainerEntityManagerFactoryBean();
		emFactory.setDataSource(ds);
		emFactory.setJpaVendorAdapter(jpaVendorAdapter);
		emFactory.setPackagesToScan("com.coursecube.springboot");
		return emFactory;
	}

	@Bean(name = "jlcTransactionManager")
	public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactory) {
		EntityManagerFactory factory = entityManagerFactory.getObject();
		return new JpaTransactionManager(factory);
	}

}
