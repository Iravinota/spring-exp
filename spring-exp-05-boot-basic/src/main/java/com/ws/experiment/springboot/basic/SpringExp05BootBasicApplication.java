package com.ws.experiment.springboot.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@Slf4j
public class SpringExp05BootBasicApplication implements CommandLineRunner {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringExp05BootBasicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		showConnections();
		showData();
	}

	private void showConnections() throws SQLException {
		log.info("哈哈哈哈哈哈" + dataSource.toString());
		Connection conn = dataSource.getConnection();
		log.info("哈哈哈哈哈哈" + conn.toString());
		conn.close();
	}

	private void showData() {
		jdbcTemplate.queryForList("select * from foo")
				.forEach(row -> log.info(row.toString()));
	}
}
