package com.example.greenpotback.Controllers;

import com.example.greenpotback.Dto.PlantAllDataDto;
import com.example.greenpotback.Plant.Calendar.Calendar;
import com.example.greenpotback.Plant.Image.Image;
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

    @GetMapping("/all-info/id")
    public ResponseEntity<PlantAllDataDto> getAllDataById(Integer id){
        Plant plant = plantService.findPlantByID(id);

        if(plant == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        List<Image> images = plantService.findAllImagesByPlantId(id);

        for(Image image : images){
            image.setFilePath(ControllerConst.PLANT_IMAGES_PATH + id + "/" + image.getFilePath());
        }

        PlantAllDataDto allCollectedData = new PlantAllDataDto();
        allCollectedData.setPlant(plant);
        allCollectedData.setSubCategoriesList((ArrayList<SubCategory>) plantService.findAllSubCatByPlantId(id));
        allCollectedData.setImagesList((ArrayList<Image>) images);
        allCollectedData.setCalendarList((ArrayList<Calendar>) plantService.findAllCalendarByPlantId(id));

        return new ResponseEntity<>(allCollectedData,HttpStatus.OK);
    }



}
