package com.example.greenpotback.Controllers;

import com.example.greenpotback.Dto.PlantAllDataDto;
import com.example.greenpotback.Plant.Calendar.Calendar;
import com.example.greenpotback.Plant.Image.Image;
import com.example.greenpotback.Plant.MainCategory.MainCategory;
import com.example.greenpotback.Plant.Plant;
import com.example.greenpotback.Plant.PlantServiceImp;
import com.example.greenpotback.Plant.SubCategory.SubCategory;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/plant")
public class PlantController {

    private final PlantServiceImp plantService;

//    PLANT
    @GetMapping("/info/id")
    public ResponseEntity<PlantAllDataDto> getPlantAllDataById(Integer id){

        if(plantService.findPlantByID(id) == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(collectData(id),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PlantAllDataDto>> getAllPlants(){
        List<Plant> plants = plantService.getAllPlants();
        List<PlantAllDataDto> allPlants = new ArrayList<>();

        for(Plant plant : plants){
            allPlants.add(collectData(plant.getId()));
        }

        return new ResponseEntity<>(allPlants,HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<PlantAllDataDto>> getPlantByCategory(String category){
        List<Plant> plants = plantService.getPlantsByCategory(category);
        List<PlantAllDataDto> allPlants = new ArrayList<>();

        for(Plant plant : plants){
            allPlants.add(collectData(plant.getId()));
        }

        return new ResponseEntity<>(allPlants,HttpStatus.OK);
    }

//    MAIN_CATEGORY
    @GetMapping("/main-category/all")
    public ResponseEntity<List<MainCategory>> getAllMainCategories(){
        return new ResponseEntity<>(plantService.findAllMainCategory(),HttpStatus.OK);
    }

//    SUB_CATEGORY
    @GetMapping("/sub-category/all")
    public ResponseEntity<List<SubCategory>> getAllSubCategory(){
        return new ResponseEntity<>(plantService.findAllSubCategory(),HttpStatus.OK);
    }




    private PlantAllDataDto collectData(Integer id){
        Plant plant = plantService.findPlantByID(id);
        List<Image> images = plantService.findAllImagesByPlantId(id);

        for(Image image : images){
            image.setFilePath(ControllerConst.PLANT_IMAGES_PATH + id + "/" + image.getFilePath());
        }

        PlantAllDataDto allCollectedData = new PlantAllDataDto();
        allCollectedData.setPlant(plant);
        allCollectedData.setSubCategoriesList((ArrayList<SubCategory>) plantService.findAllSubCatByPlantId(id));
        allCollectedData.setImagesList((ArrayList<Image>) images);
        allCollectedData.setCalendarList((ArrayList<Calendar>) plantService.findAllCalendarByPlantId(id));

        return allCollectedData;
    }

}
