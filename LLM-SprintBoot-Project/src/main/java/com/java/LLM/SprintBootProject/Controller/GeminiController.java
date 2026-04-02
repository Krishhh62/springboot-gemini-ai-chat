package com.java.LLM.SprintBootProject.Controller;

import com.java.LLM.SprintBootProject.DTO.ChatRequest;
import com.java.LLM.SprintBootProject.DTO.ChatResponse;
import com.java.LLM.SprintBootProject.Service.GeminiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gemini/chat")
@RequiredArgsConstructor
public class GeminiController {

    private final GeminiService geminiService;

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request){
        String reply = geminiService.getResponse(request.getMessage());
        ChatResponse response = new ChatResponse();
        response.setReply(reply);
        return response;
    }
}
