package com.example.greenpotback.Plant.SubCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
}
