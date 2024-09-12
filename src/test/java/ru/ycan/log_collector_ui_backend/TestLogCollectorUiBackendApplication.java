package ru.ycan.log_collector_ui_backend;

import org.springframework.boot.SpringApplication;

public class TestLogCollectorUiBackendApplication {

	public static void main(String[] args) {
		SpringApplication.from(LogCollectorUiBackendApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
