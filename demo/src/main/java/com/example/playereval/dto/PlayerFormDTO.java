package com.example.playereval.dto;

import java.util.HashMap;
import java.util.Map;

public class PlayerFormDTO {
    private Integer playerId;
    private String name;
    private String fullName;
    private String age;
    private Map<String, Float> indexValues = new HashMap<>();
    
    // Getters and Setters
    public Integer getPlayerId() { return playerId; }
    public void setPlayerId(Integer playerId) { this.playerId = playerId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    
    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }
    
    public Map<String, Float> getIndexValues() { return indexValues; }
    public void setIndexValues(Map<String, Float> indexValues) { this.indexValues = indexValues; }
}