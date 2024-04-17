package HomeDelivery.Ecommerce;
import HomeDelivery.Ecommerce.dto.ProductDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"services", "HomeDelivery.Ecommerce.controllers"})
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}
	@Bean
	public ProductDTO productDTO() {
		return new ProductDTO(); // Instantiate and return a ProductDTO bean
	}
}
