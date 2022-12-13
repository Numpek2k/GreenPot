package com.example.greenpotback.Plant;

import com.example.greenpotback.Dto.MyCalendarDTO;
import com.example.greenpotback.Dto.PlantAllDataDto;
import com.example.greenpotback.Plant.Calendar.Calendar;
import com.example.greenpotback.Plant.Calendar.Event.Event;
import com.example.greenpotback.Plant.Image.Image;
import com.example.greenpotback.Plant.MainCategory.MainCategory;
import com.example.greenpotback.Plant.SubCategory.SubCategory;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;

public interface PlantService {

//    PLANT
    Plant findPlantByID(Integer id);

    List<Plant> getAllPlants();

    List<Plant> getPlantsByCategory(String category);

    List<Plant> getPlantsBySubCategory(List<String> subCat);

    List<Plant> getMyCalenderByEmail(String email);

    List<Plant> getPlantsByAuthor(Integer id);

    Integer savePlant(Plant plant, Principal user);

    List<Plant> getLatestPostWithLimit();

    void uploadPhoto(MultipartFile file, Integer id);
//    MAIN_CATEGORY

    List<MainCategory> findAllMainCategory();

//    SUB_CATEGORY
    List<SubCategory> findAllSubCategory();

    List<SubCategory> findAllSubCatByPlantId(Integer id);
//    IMAGE

    List<Image> findAllImagesByPlantId(Integer id);

    Image getImageByPlantIdLimit(Integer id);

//    CALENDAR

    List<Calendar> findAllCalendarByPlantId(Integer id);

//    EVENT

    List<Event> findAllEvent();

//    OTHER

    PlantAllDataDto collectAllData(Plant plant);

    MyCalendarDTO collectMyCalendar(Plant plant);
}
