package br.com.alura.Academia;


import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

@SpringBootApplication
public class Configuracao {

		
	public static void main(String[] args) {
		SpringApplication.run(Configuracao.class, args);
		
	}

	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/academia?useTimezone=true&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("michel27");			
		return dataSource;
	}
		
	@Bean
    public Java8TimeDialect java8TimeDialect() {
        return new Java8TimeDialect();
    
    }

	
@Bean
public JpaVendorAdapter jpaVendorAdapter(){
	HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	adapter.setShowSql(true);
	adapter.setGenerateDdl(true);
	adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
	adapter.setPrepareConnection(true);
	return adapter;
}
}
	

		
	


