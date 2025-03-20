package spring.ai.example.spring_ai_demo.service

import org.springframework.ai.openai.api.OpenAiApi
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Service
class ReactiveDeepSeekService {

    @Value('${app.test.initial.configuration}')
    public boolean APP_TEST_INITIAL_CONFIGURATION;

    @Autowired
    private WebClient webClient

    Mono<String> generateResponse(String prompt) {
        OpenAiApi.ChatCompletionRequest request = new OpenAiApi.ChatCompletionRequest(
                List.of(new OpenAiApi.ChatCompletionMessage(prompt, OpenAiApi.ChatCompletionMessage.Role.USER)),
                "deepseek-chat",
                0.0,
                false)
        return webClient.post()
                .uri("/chat/completions") // Replace with the actual DeepSeek API endpoint
                .bodyValue(request) // Replace with the actual request body
                .retrieve()
                .bodyToMono(String) // Replace with the actual response type
    }
}
