
package com.spa.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spa.demo.entity.Event;

@Repository
public interface EventRepo extends JpaRepository<Event, Integer> {

	@Query("from Event e order by e.id")
	List<Event> findAll();
	List<Event> findByStatus(String status);
	Event findByTitle(String title);
}