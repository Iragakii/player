package com.example.playereval.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer playerId;
    
    private String name;
    private String fullName;
    private String age;
    
    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<PlayerIndex> playerIndices;
    
    // Getters and Setters
    public Integer getPlayerId() { return playerId; }
    public void setPlayerId(Integer playerId) { this.playerId = playerId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    
    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }
    
    public List<PlayerIndex> getPlayerIndices() { return playerIndices; }
    public void setPlayerIndices(List<PlayerIndex> playerIndices) { this.playerIndices = playerIndices; }
}