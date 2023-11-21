package com.marmont.chatbot.controller;

import com.marmont.chatbot.service.ChatbotService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/chatbot")
public class ChatbotController {

    private final ChatbotService chatbotService;
    private static final Logger logger = LoggerFactory.getLogger(ChatbotController.class);

    @GetMapping("/")
    public String home() {
        logger.info("Loading home page");
        return "chatbot";
    }

    @PostMapping
    @ResponseBody
    public String chat(@RequestBody String userInput) {
        return chatbotService.getResponse(userInput);
    }
}
