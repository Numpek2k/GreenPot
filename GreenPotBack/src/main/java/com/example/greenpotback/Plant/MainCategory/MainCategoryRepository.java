package com.example.greenpotback.Plant.MainCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainCategoryRepository extends JpaRepository<MainCategory, Integer> {
    MainCategory findByName(String name);
}
