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

@SpringBootApplication	// spring-boot入口的注解
@Slf4j					// lombok简化操作
public class BasicApplication implements CommandLineRunner {	// CommandLineRunner会使spring-boot回调run()函数

	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public static void main(String[] args) {	// spring-boot入口
		SpringApplication.run(BasicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		showConnections();
		showData();
	}

	private void showConnections() throws SQLException {
		log.info(">>>> " + dataSource.toString());
		Connection conn = dataSource.getConnection();
		log.info(">>>> " + conn.toString());
		conn.close();
	}

	private void showData() {
		jdbcTemplate.queryForList("select * from foo")
				.forEach(row -> log.info(">>>> " + row.toString()));
	}
}
