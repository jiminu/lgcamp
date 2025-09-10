package com.lgcns.inspire_restjpa.openai.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lgcns.inspire_restjpa.openai.domain.dto.ChatResponseDTO;
import com.lgcns.inspire_restjpa.openai.domain.dto.QuizResponseDTO;
import com.lgcns.inspire_restjpa.openai.service.ChatService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v2/inspire/ai")
public class ChatCtrl {
    
    @Autowired
    private ChatService chatService;
    
    
    @PostMapping("/chat")
    public ResponseEntity<ChatResponseDTO> chat(
        @RequestParam(name="weather") String weather,
        @RequestParam(name="location") String location
        ) {
        System.out.println("[DEBUG] >>> open ai chat ");
        System.out.println("[DEBUG] >>> weather  : " + weather);
        System.out.println("[DEBUG] >>> location : " + location);
        
        ChatResponseDTO result = chatService.recommendRestaurant(weather, location);
        
        return ResponseEntity.ok().body(result);
    }
    
    @PostMapping("/quiz")
    public ResponseEntity<QuizResponseDTO> quiz() {
        System.out.println("[DEBUG] >>> open ai quiz ");
        
        QuizResponseDTO result = chatService.generateQuiz();
        
        return ResponseEntity.ok().body(result);
    }
    
}
