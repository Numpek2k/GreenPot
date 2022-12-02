package com.example.greenpotback.Plant;

import com.example.greenpotback.Plant.Calendar.Calendar;
import com.example.greenpotback.Plant.Image.Image;
import com.example.greenpotback.Plant.SubCategory.SubCategory;

import java.util.List;

public interface PlantService {

    Plant findPlantByID(Integer id);

    List<SubCategory> findAllSubCatByPlantId(Integer id);

    List<Image> findAllImagesByPlantId(Integer id);

    List<Calendar> findAllCalendarByPlantId(Integer id);

}
