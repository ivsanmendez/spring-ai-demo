package spring.ai.example.spring_ai_demo.cfg

import org.springframework.ai.openai.api.OpenAiApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class DeepSeekConfiguration {

    @Value('${spring.ai.openai.api-key}')
    private String API_KEY;

    @Value('${spring.ai.openai.base-url}')
    private String API_URL;

    @Bean
    WebClient getReactiveDeepSeekService() {
        WebClient.builder()
                .baseUrl("${API_URL}/v1") // Replace with DeepSeek's base URL
                .defaultHeader("Authorization", "Bearer ${API_KEY}") // Use the injected token
                .build()
    }

    @Bean
    OpenAiApi getOpenAiApi() {
        OpenAiApi.builder()
                .apiKey(API_KEY)
                .baseUrl(API_URL)
                .build()
    }
}