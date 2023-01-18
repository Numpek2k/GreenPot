package com.example.greenpotback.Plant.Calendar.Event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    @Query("select e from Event e where e.name = ?1")
    Event findByName(String name);

}
