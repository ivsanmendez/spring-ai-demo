package spring.ai.example.spring_ai_demo.service;

import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeepSeekService {

    private final OpenAiApi openAiApi;

    @Autowired
    public DeepSeekService(OpenAiApi openAiApi) {
        this.openAiApi = openAiApi;
    }

    public String generateResponse(String prompt) {
        OpenAiApi.ChatCompletionRequest request = new OpenAiApi.ChatCompletionRequest(
                List.of(new OpenAiApi.ChatCompletionMessage(prompt, OpenAiApi.ChatCompletionMessage.Role.USER)),
                "deepseek-chat",
                0.0,
                false);

        ResponseEntity<OpenAiApi. ChatCompletion> response = openAiApi.chatCompletionEntity(request);
        return response.getBody().choices().get(0).message().content();
    }
}