package com.example.greenpotback.Plant.Image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {

    @Query("select i from Image i where i.plant.id = ?1")
    List<Image> findImagesByPlantId(Integer id);

    Image getFirstImageByPlantId(Integer id);
}
