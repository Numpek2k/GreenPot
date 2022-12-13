package com.example.greenpotback.Plant.SubCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Set;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
    @Query("select s from SubCategory s inner join s.plants plants where plants.id = ?1")
    List<SubCategory> findSubCategoriesByPlantsId(Integer id);

    @Query("select s from SubCategory s where s.name in ?1")
    Set<SubCategory> findAllByNameIn(Set<String> subCategories);
}
