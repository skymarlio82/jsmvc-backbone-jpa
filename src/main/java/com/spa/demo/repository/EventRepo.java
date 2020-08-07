package com.spa.demo.repository;

import com.spa.demo.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepo extends JpaRepository<Event, Integer> {

    @Query("from Event e order by e.id")
    List<Event> findAll();

    List<Event> findByStatus(String status);

    Event findByTitle(String title);
}