package com.example.playereval.entity;

import javax.persistence.*;

@Entity
@Table(name = "player_index")
public class PlayerIndex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
    
    @ManyToOne
    @JoinColumn(name = "index_id")
    private Indexer indexer;
    
    private Float value;
    
    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    
    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }
    
    public Indexer getIndexer() { return indexer; }
    public void setIndexer(Indexer indexer) { this.indexer = indexer; }
    
    public Float getValue() { return value; }
    public void setValue(Float value) { this.value = value; }
}