package spring.ai.example.spring_ai_demo

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import spring.ai.example.spring_ai_demo.service.DeepSeekService

@SpringBootApplication
class SpringAiDemoApplication {

	static void main(String[] args) {
		SpringApplication.run(SpringAiDemoApplication, args)
	}

	@Bean
	CommandLineRunner runner(DeepSeekService deepSeekService) {
		return (args) -> {
			String response = deepSeekService.generateResponse("Tell me a joke");
			System.out.println(response);
		};
	}


}
