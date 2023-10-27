package com.example.demo.Repo;

import com.example.demo.Entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepo extends JpaRepository<History, Long> {
/*Iterable<HistoryEntity>*/
}
