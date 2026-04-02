package com.java.LLM.SprintBootProject.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;

    @Value("${gemini.api.url}")
    private String apiUrl;

    //tool to call internet API
    private final RestTemplate restTemplate = new RestTemplate();

    public String getResponse(String userMessage){
        String urlWithKey = apiUrl + "?key=" + apiKey;
        Map<String,Object> textPart = Map.of("text",userMessage);
        Map<String,Object> parts = Map.of("parts", List.of(textPart));
        Map<String,Object> requestBody = Map.of("contents",List.of(parts));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        //create http request
        HttpEntity<Map<String,Object>> request = new HttpEntity<>(requestBody,headers);

        //call gemini API
        ResponseEntity<Map> response = restTemplate.postForEntity(urlWithKey,request,Map.class);

        //get list of answers
        List<Map<String,Object>> candidates = (List<Map<String, Object>>) response.getBody().get("candidates");

        if(candidates==null || candidates.isEmpty()){
            return "No Response from Gemini AI";
        }

        //take first answer
        Map<String,Object> content = (Map<String, Object>) candidates.get(0).get("content");

        //get parts
        List<Map<String,Object>> partsList = (List<Map<String, Object>>) content.get("parts");

        //get final text
        return (String) partsList.get(0).get("text");

    }
}
