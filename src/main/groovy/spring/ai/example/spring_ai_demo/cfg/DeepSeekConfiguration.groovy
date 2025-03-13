package spring.ai.example.spring_ai_demo.cfg

import org.springframework.ai.chat.client.ChatClient
import org.springframework.ai.openai.api.OpenAiApi
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DeepSeekConfiguration {

    @Value('${spring.ai.openai.api-key}')
    private String apiKey;

    @Value('${spring.ai.openai.base-url}')
    private String apiUrl;

    @Bean
    ChatClient getChatClient(ChatClient.Builder builder) {
        builder.build()
    }

    @Bean
    OpenAiApi getOpenAiApi() {
        OpenAiApi.builder()
                .apiKey(apiKey)
                .baseUrl(apiUrl)
                .build()
    }
}