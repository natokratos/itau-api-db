package com.itau.api.config;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class DBConfig {
	@Value("${db.server.port}")
	private String dbServerPort;
	
	@Bean(initMethod = "start", destroyMethod = "stop")
	public Server DBServer() throws SQLException {
	    return Server.createTcpServer(
	      "-tcp", "-tcpAllowOthers", "-tcpPort", dbServerPort).start();
	}
}
