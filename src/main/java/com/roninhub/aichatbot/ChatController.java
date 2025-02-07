package com.roninhub.aichatbot;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ChatController {

    private final LLMConnector llmConnector;

    @PostMapping(value = "/conversation", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<String>> chat(@RequestBody PromptRequest request) {
        // Return SSEs
        return llmConnector.respond(request.getContent())
                .map(token -> ServerSentEvent.builder(token).build());

        // TODO
        // At the beginning of the stream, return small chucks fast.
        // After some time, return batches of tokens.
    }
}
