package com.example.greenpotback.Plant.Calendar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Integer> {
    @Query("select c from Calendar c where c.plant.id = ?1 order by c.dateStart")
    List<Calendar> findAllByPlantIdOrderByDateStart(Integer id);

}
