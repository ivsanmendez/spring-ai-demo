package spring.ai.example.spring_ai_demo.client

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

import spring.ai.example.spring_ai_demo.service.ReactiveDeepSeekService

@RestController
class DeepSeekController {

    @Autowired
    private final ReactiveDeepSeekService reactiveDeepSeekService

    @GetMapping("/deepSeek")
    Mono<String> getDeepSeekResponse(@RequestParam(value = "message", defaultValue = "Hello") String message) {
        return reactiveDeepSeekService.generateResponse(message)
                .doOnNext { response -> System.out.println(response) }
    }
}