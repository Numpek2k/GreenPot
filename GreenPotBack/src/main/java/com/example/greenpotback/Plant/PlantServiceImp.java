package com.example.greenpotback.Plant;

import com.example.greenpotback.Controllers.ControllerConst;
import com.example.greenpotback.Dto.MyCalendarDTO;
import com.example.greenpotback.Dto.PlantAllDataDto;
import com.example.greenpotback.Plant.Calendar.Calendar;
import com.example.greenpotback.Plant.Calendar.CalendarRepository;
import com.example.greenpotback.Plant.Image.Image;
import com.example.greenpotback.Plant.Image.ImageRepository;
import com.example.greenpotback.Plant.MainCategory.MainCategory;
import com.example.greenpotback.Plant.MainCategory.MainCategoryRepository;
import com.example.greenpotback.Plant.SubCategory.SubCategory;
import com.example.greenpotback.Plant.SubCategory.SubCategoryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PlantServiceImp implements PlantService {

    private final PlantRepository plantRepository;

    private final MainCategoryRepository mainCategoryRepository;

    private final SubCategoryRepository subCategoryRepository;

    private final ImageRepository imageRepository;

    private final CalendarRepository calendarRepository;

    @Override
    public Plant findPlantByID(Integer id) {
        return plantRepository.findPlantById(id);
    }

    @Override
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    @Override
    public List<Plant> getPlantsByCategory(String category) {
        return plantRepository.findAllByCategoryName(category);
    }

    @Override
    public List<Plant> getPlantsBySubCategory(List<String> subCat) {
        return plantRepository.findAllBySubCategoriesNameIn(subCat);
    }

    @Override
    public List<Plant> getMyCalenderByEmail(String email) {
        return plantRepository.findAllByObserversEmail(email);
    }

    @Override
    public List<MainCategory> findAllMainCategory() {
        return mainCategoryRepository.findAll();
    }

    @Override
    public List<SubCategory> findAllSubCategory() {
        return subCategoryRepository.findAll();
    }

    @Override
    public List<SubCategory> findAllSubCatByPlantId(Integer id) {
        return subCategoryRepository.findSubCategoriesByPlantsId(id);
    }

    @Override
    public List<Image> findAllImagesByPlantId(Integer id) {
        return imageRepository.findImagesByPlantId(id);
    }

    @Override
    public List<Calendar> findAllCalendarByPlantId(Integer id) {
        return calendarRepository.findAllByPlantIdOrderByDateStart(id);
    }

    @Override
    public PlantAllDataDto collectAllData(Plant plant){
        int id = plant.getId();
        List<Image> images = findAllImagesByPlantId(id);

        for(Image image : images){
            image.setFilePath(ControllerConst.PLANT_IMAGES_PATH + id + "/" + image.getFilePath());
        }

        PlantAllDataDto allCollectedData = new PlantAllDataDto();
        allCollectedData.setPlant(plant);
        allCollectedData.setSubCategoriesList(findAllSubCatByPlantId(id));
        allCollectedData.setImagesList(images);
        allCollectedData.setCalendarList(findAllCalendarByPlantId(id));

        return allCollectedData;
    }

    @Override
    public MyCalendarDTO collectMyCalendar(Plant plant) {

        MyCalendarDTO allCollectedData = new MyCalendarDTO();
        allCollectedData.setPlant(plant);
        allCollectedData.setCalendarList(findAllCalendarByPlantId(plant.getId()));

        return allCollectedData;
    }
}
