package com.example.greenpotback.Plant.MainCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MainCategoryRepository extends JpaRepository<MainCategory, Integer> {
    @Query("select m from MainCategory m where m.name = ?1")
    MainCategory findByName(String name);
}
