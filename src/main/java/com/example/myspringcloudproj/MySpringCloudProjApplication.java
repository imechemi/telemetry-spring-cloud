package com.example.myspringcloudproj;

import com.example.myspringcloudproj.processor.EventProcessor;
import com.example.myspringcloudproj.processor.Telemetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MySpringCloudProjApplication implements CommandLineRunner {

	@Autowired
	private EventProcessor eventProcessor;

	public static void main(String[] args) {
		SpringApplication.run(MySpringCloudProjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Publishing event ....");
		Telemetry telemetry = new Telemetry("device-id-0");
		eventProcessor.process(telemetry);
	}
}
