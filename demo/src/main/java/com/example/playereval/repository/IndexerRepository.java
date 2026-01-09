package com.example.playereval.repository;

import com.example.playereval.entity.Indexer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndexerRepository extends JpaRepository<Indexer, Integer> {
    List<Indexer> findAll();
}