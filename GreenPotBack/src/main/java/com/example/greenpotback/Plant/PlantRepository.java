package com.example.greenpotback.Plant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {

    @Query("select p from Plant p where p.id = ?1")
    Plant findPlantById(Integer id);

    @Query("select p from Plant p where p.category.name = ?1")
    List<Plant> findAllByCategoryName(String name);

    @Query("select p from Plant p inner join p.subCategories subCategories where subCategories.name in ?1")
    List<Plant> findAllBySubCategoriesNameIn(List<String> name);

    @Query("select p from Plant p inner join p.observers observers where observers.email = ?1")
    List<Plant> findAllByObserversEmail(String email);

    @Query("select p from Plant p where p.author.id = ?1")
    List<Plant> findAllByAuthorId(Integer id);
}
