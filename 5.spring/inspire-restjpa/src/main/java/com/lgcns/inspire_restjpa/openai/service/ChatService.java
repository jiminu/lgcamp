package com.lgcns.inspire_restjpa.openai.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgcns.inspire_restjpa.openai.domain.dto.ChatResponseDTO;
import com.lgcns.inspire_restjpa.openai.domain.dto.QuizResponseDTO;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class ChatService {
    
    @Value("${OPEN_AI_MODEL}")
    private String model;
    @Value("${OPEN_AI_KEY}")
    private String aiKey;
    @Value("${spring.ai.openai.api.url}")
    private String url;
    
    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();
    
    public ChatResponseDTO recommendRestaurant(String weather, String location) {
        System.out.println("[DEBUG] chat service recommend restaurant");
        // String prompt = "너는 성능이 어마어마한 인공지능이다. \n" +
        //                 "조건이 다음과 같을 때 기가 막힌 음식점을 추천해라. \n" +
        //                 "현재 날씨는 '" + weather + "', 위치는 '" + location + "'이다. \n" +
        //                 "응답 형식은 다음과 같은 json이다. \n" + 
        //                 "{\n" +
        //                 "\"location\" : \"<지역>\", \n" +
        //                 "\"weather\" : \"<날씨>\", \n" +
        //                 "\"restaurants\" : [\n " +
        //                 "{\"name\" : \"<가게명>\", " +
        //                 "\"category\" : \"<분류>\", " +
        //                 "\"reason\" : \"<추천이유>\" }" +
        //                 "]\n" +
        //                 "}";
        String prompt = """
        너는 성능이 어마어마한 인공지능이다.  
        조건이 다음과 같을 때 기가 막힌 음식점을 추천해라.  
        현재 날씨는 "%s", 위치는 "%s" 이다.  
        응답 형식은 다음과 같은 json이다.   
        `은 사용하지 마라.
        { 
         "location ": "<지역>",  
         "weather" : "<날씨>",  
         "restaurants" : [  
                        {"name" : "<가게명>",  
                         "category" : "<분류>",  
                         "reason" : "<추천이유>" } 
                        ] 
        }
        """.formatted(weather, location);                                
                        
        /*
            open ai chat api 대화형식(message) : role, content
            role: system - ai model,
                  user - prompt
                  
            { model: gpt-4o-mini
              message: [
                  {role: system,
                   content: ""},
                  {role: user,
                   content: prompt},
              ]
            }
                  
         */                

        // message 생성
        Map<String, Object> systemMsg = new HashMap<>();
        systemMsg.put("role", "system");
        systemMsg.put("content", "넌 반드시 json 포맷을 지켜야 한다.");
        Map<String, Object> userMsg = new HashMap<>();
        userMsg.put("role", "user");
        userMsg.put("content", prompt);
        Map<String, Object> requestMsg = new HashMap<>();
        requestMsg.put("model", model);
        requestMsg.put("messages", List.of(systemMsg, userMsg));
        
        // object to json string
        String json = null;
        try {
            json = mapper.writeValueAsString(requestMsg);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("REQUEST JSON");
        System.out.println(json);
        
        Request request = new Request.Builder()
                                     .url(url)
                                     .header("Authorization", "Bearer " + aiKey)
                                     .header("Content-Type", "application/json")
                                     .post(RequestBody.create(json, MediaType.parse("application/json")))
                                     .build();
        
        String responseJson = null;
        try (Response response = client.newCall(request).execute()) {
            System.out.println("[DEBUG] response >>>>>>>>>>");
            responseJson = response.body().string();
            System.out.println(responseJson);
            
            JsonNode node = mapper.readTree(responseJson);
            // node.at("/choices/0/message/content").asText();
            return mapper.readValue(node.at("/choices/0/message/content").asText(), 
                                    ChatResponseDTO.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public QuizResponseDTO generateQuiz() {
        System.out.println("[DEBUG] chat service recommend restaurant");

        String prompt = """
                너는 성능이 어마어마한 인공지능이다.
                넌 이제 기가 막힌 자바문제를 출제할 것이다.
                4지선다형으로 응답할 수 있는 문제를 2개 내라. 
                응답 형식은 다음과 같은 json이다.
                파싱해야 하므로 `와 \\ 는 사용하지 마라.
                {
                    "quizs" : [
                        {
                            "question" : "<문제내용>",
                            "options" : "["보기1", "보기2", "보기3", 보기4"]",
                            "answer" : "<정답>"
                        }
                    ]
                }
                """;

        /*
         * open ai chat api 대화형식(message) : role, content
         * role: system - ai model,
         * user - prompt
         * 
         * { model: gpt-4o-mini
         * message: [
         * {role: system,
         * content: ""},
         * {role: user,
         * content: prompt},
         * ]
         * }
         * 
         */

        // message 생성
        Map<String, Object> systemMsg = new HashMap<>();
        systemMsg.put("role", "system");
        systemMsg.put("content", "넌 반드시 json 포맷을 지켜야 한다.");
        Map<String, Object> userMsg = new HashMap<>();
        userMsg.put("role", "user");
        userMsg.put("content", prompt);
        Map<String, Object> requestMsg = new HashMap<>();
        requestMsg.put("model", model);
        requestMsg.put("messages", List.of(systemMsg, userMsg));

        // object to json string
        String json = null;
        try {
            json = mapper.writeValueAsString(requestMsg);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("REQUEST JSON");
        System.out.println(json);

        Request request = new Request.Builder()
                .url(url)
                .header("Authorization", "Bearer " + aiKey)
                .header("Content-Type", "application/json")
                .post(RequestBody.create(json, MediaType.parse("application/json")))
                .build();

        String responseJson = null;
        try (Response response = client.newCall(request).execute()) {
            System.out.println("[DEBUG] response >>>>>>>>>>");
            responseJson = response.body().string();
            System.out.println(responseJson);

            JsonNode node = mapper.readTree(responseJson);
            node.at("/choices/0/message/content").asText();
            return mapper.readValue(node.at("/choices/0/message/content").asText(),
                    QuizResponseDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
