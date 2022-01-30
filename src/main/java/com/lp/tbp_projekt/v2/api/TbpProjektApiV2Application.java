package com.lp.tbp_projekt.v2.api;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class})
@EnableNeo4jRepositories
public class TbpProjektApiV2Application implements CommandLineRunner
{
	private DataGenerator dataGenerator;

	public TbpProjektApiV2Application(DataGenerator dataGenerator)
	{
		this.dataGenerator = dataGenerator;
	}

	public static void main(String[] args) {
		SpringApplication.run(TbpProjektApiV2Application.class, args);
		System.out.println("lol");
	}

	@Override
	public void run(final String... args)
	{
		//dataGenerator.deleteExistingData();
		//dataGenerator.generateData();
	}
}
