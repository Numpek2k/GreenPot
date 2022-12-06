package com.example.greenpotback.Plant;

import com.example.greenpotback.Dto.MyCalendarDTO;
import com.example.greenpotback.Dto.PlantAllDataDto;
import com.example.greenpotback.Plant.Calendar.Calendar;
import com.example.greenpotback.Plant.Image.Image;
import com.example.greenpotback.Plant.MainCategory.MainCategory;
import com.example.greenpotback.Plant.SubCategory.SubCategory;

import java.util.List;

public interface PlantService {

//    PLANT
    Plant findPlantByID(Integer id);

    List<Plant> getAllPlants();

    List<Plant> getPlantsByCategory(String category);

    List<Plant> getPlantsBySubCategory(List<String> subCat);

    List<Plant> getMyCalenderByEmail(String email);

//    MAIN_CATEGORY

    List<MainCategory> findAllMainCategory();
//    SUB_CATEGORY

    List<SubCategory> findAllSubCategory();

    List<SubCategory> findAllSubCatByPlantId(Integer id);
//    IMAGE

    List<Image> findAllImagesByPlantId(Integer id);
//    CALENDAR

    List<Calendar> findAllCalendarByPlantId(Integer id);

//    OTHER

    PlantAllDataDto collectAllData(Plant plant);

    MyCalendarDTO collectMyCalendar(Plant plant);
}
