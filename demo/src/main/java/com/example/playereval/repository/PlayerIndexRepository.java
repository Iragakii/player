package com.example.playereval.repository;

import com.example.playereval.entity.PlayerIndex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerIndexRepository extends JpaRepository<PlayerIndex, Integer> {
}