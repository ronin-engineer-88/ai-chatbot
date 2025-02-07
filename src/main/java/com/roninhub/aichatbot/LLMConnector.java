package com.roninhub.aichatbot;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class LLMConnector {

    /**
     * Simulates generating a chatbot response token by token.
     *
     * @param prompt The user’s question.
     * @return A Flux that emits tokens as Strings.
     */
    public Flux<String> respond(String prompt) {
        return Flux.interval(Duration.ofMillis(250))
                .take(15)
                .map(seq -> "Response token " + (seq + 1) + " for question: " + prompt);    // Tokens
    }
}
