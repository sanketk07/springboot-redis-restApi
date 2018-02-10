package com.sanket.bigdata.demo1;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.sanket.bigdata.demo1.utils.ValidationUtils;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class Demo1Application {

	public static void main(String[] args) {

		File schemaFile = new File("/Users/sanketkumar/Downloads/demo1/src/main/resources/schema.json");
		File jsonFile = new File("/Users/sanketkumar/Downloads/demo1/src/main/resources/data.json");
		
		/* curl -H "Content-Type: application/json" -X PUT  -d /Users/sanketkumar/Downloads/demo1/src/main/resources/data.json http://localhost:8080/persons
		 * */

		try {
			if (ValidationUtils.isJsonValid(schemaFile, jsonFile)) {
				System.out.println("Valid!");
			} else {
				System.out.println("NOT valid!");
			}
		} catch (ProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SpringApplication.run(Demo1Application.class, args);

	}
}
