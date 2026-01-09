package com.example.playereval.service;

import com.example.playereval.dto.PlayerFormDTO;
import com.example.playereval.entity.*;
import com.example.playereval.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    
    @Autowired
    private PlayerRepository playerRepository;
    
    @Autowired
    private IndexerRepository indexerRepository;
    
    @Autowired
    private PlayerIndexRepository playerIndexRepository;
    
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
    
    public Optional<Player> getPlayerById(Integer id) {
        return playerRepository.findById(id);
    }
    
    @Transactional
    public Player savePlayer(PlayerFormDTO dto) {
        Player player = new Player();
        if (dto.getPlayerId() != null) {
            player = playerRepository.findById(dto.getPlayerId()).orElse(new Player());
        }
        
        player.setName(dto.getName());
        player.setFullName(dto.getFullName());
        player.setAge(dto.getAge());
        
        Player savedPlayer = playerRepository.save(player);
        
        // 保存指标值
        List<Indexer> allIndexers = indexerRepository.findAll();
        for (Indexer indexer : allIndexers) {
            Float value = dto.getIndexValues().get(indexer.getName());
            if (value != null) {
                PlayerIndex playerIndex = new PlayerIndex();
                playerIndex.setPlayer(savedPlayer);
                playerIndex.setIndexer(indexer);
                playerIndex.setValue(value);
                playerIndexRepository.save(playerIndex);
            }
        }
        
        return savedPlayer;
    }
    
    @Transactional
    public void deletePlayer(Integer id) {
        playerRepository.deleteById(id);
    }
    
    public List<Indexer> getAllIndexers() {
        return indexerRepository.findAll();
    }
}