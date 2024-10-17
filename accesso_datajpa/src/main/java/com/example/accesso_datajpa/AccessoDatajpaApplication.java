package com.example.accesso_datajpa;
import com.example.accesso_datajpa.entities.Category;
import com.example.accesso_datajpa.entities.Product;
import com.example.accesso_datajpa.entities.User;
import com.example.accesso_datajpa.repositories.CategoryRepository;
import com.example.accesso_datajpa.repositories.ProductRepository;
import com.example.accesso_datajpa.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.math.BigDecimal;
@SpringBootApplication
public class AccessoDatajpaApplication {
	private static final Logger log = LoggerFactory.getLogger(AccessoDatajpaApplication.class);

	public static void main(String[] args) { SpringApplication.run(AccessoDatajpaApplication.class, args); }

	@Bean
	public CommandLineRunner demo(ProductRepository productRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			// Crear categorías
			Category electronica = new Category("Electonica");
			Category libros = new Category("Libros");
			categoryRepository.save(electronica);
			categoryRepository.save(libros);

			// Crear usuarios
			User user1 = new User("Daniela Guzman", "dani.guzman@gmail.com", "p4ssw0rd123");
			User user2 = new User("Juan Perez", "juan.perez@gmail.com", "p4ssw0rd456");
			userRepository.save(user1);
			userRepository.save(user2);

			// Crear productos
			Product product1 = new Product("Celular", "Samsung A54", new BigDecimal("1499999.99"), electronica);
			Product product2 = new Product("Laptop", "Lenovo", new BigDecimal("4999999.99"), electronica);
			Product product3 = new Product("Diccionario", "Diccionario español", new BigDecimal("13500.00"), libros);
			productRepository.save(product1);
			productRepository.save(product2);
			productRepository.save(product3);

			log.info("Lista de todas las Categorias");
			categoryRepository.findAll().forEach(category -> {
				log.info(category.toString());
			});

			log.info("Usuario con un determinado email");
			log.info(userRepository.findByEmail("dani.guzman@gmail.com").toString());

			log.info("Producto con id 1");
			log.info(productRepository.findById(1).toString());
		};
	}
}