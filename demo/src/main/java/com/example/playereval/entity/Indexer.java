package com.example.playereval.entity;

import javax.persistence.*;

@Entity
@Table(name = "indexer")
public class Indexer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer indexId;
    
    private String name;
    private Float valueMin;
    private Float valueMax;
    
    // Getters and Setters
    public Integer getIndexId() { return indexId; }
    public void setIndexId(Integer indexId) { this.indexId = indexId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public Float getValueMin() { return valueMin; }
    public void setValueMin(Float valueMin) { this.valueMin = valueMin; }
    
    public Float getValueMax() { return valueMax; }
    public void setValueMax(Float valueMax) { this.valueMax = valueMax; }
}