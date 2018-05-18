package co.com.poli.AppInventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("co.com.poli.AppInventario")
public class AppInventarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppInventarioApplication.class, args);
	}
}
