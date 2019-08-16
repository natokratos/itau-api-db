package com.itau.api.main;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.h2.tools.Server;

@SpringBootApplication
@EntityScan(basePackages={"com.itau.api.entity"})
@EnableJpaRepositories(basePackages = {"com.itau.api.repository"})
public class ItauApiDbApplication {
	@Value("${db.server.port}")
	private String dbServerPort;
	
	public static void main(String[] args) {
		SpringApplication.run(ItauApiDbApplication.class, args);
	}

	
	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server DBServer() throws SQLException {
	    return Server.createTcpServer(
	      "-tcp", "-tcpAllowOthers", "-tcpPort", dbServerPort);
	}
}
