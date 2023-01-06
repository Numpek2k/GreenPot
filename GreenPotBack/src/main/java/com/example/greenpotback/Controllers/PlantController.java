package com.example.greenpotback.Controllers;

import com.example.greenpotback.Dto.MyCalendarDTO;
import com.example.greenpotback.Dto.PlantAllDataDto;
import com.example.greenpotback.Plant.Calendar.Calendar;
import com.example.greenpotback.Plant.Calendar.Event.Event;
import com.example.greenpotback.Plant.Image.Image;
import com.example.greenpotback.Plant.MainCategory.MainCategory;
import com.example.greenpotback.Plant.Plant;
import com.example.greenpotback.Plant.PlantServiceImp;
import com.example.greenpotback.Plant.SubCategory.SubCategory;
import com.example.greenpotback.Post.Post;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/plant")
public class PlantController {

    private final PlantServiceImp plantService;

//    PLANT
    @GetMapping("/info/id")
    public ResponseEntity<PlantAllDataDto> getPlantAllDataById(Integer id){
        Plant plant = plantService.findPlantByID(id);

        if(plant == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(plantService.collectAllData(plant),HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PlantAllDataDto>> getAllPlants(){
        List<Plant> plants = plantService.getAllPlants();
        List<PlantAllDataDto> allPlants = new ArrayList<>();

        for(Plant plant : plants){
            allPlants.add(plantService.collectAllData(plant));
        }
        return new ResponseEntity<>(allPlants,HttpStatus.OK);
    }

    @GetMapping("/by-author")
    public ResponseEntity<List<Plant>> getPlantByAuthor(@RequestParam Integer id){
        return new ResponseEntity<>(plantService.getPlantsByAuthor(id),HttpStatus.OK);
    }

    @GetMapping("/category")
    public ResponseEntity<List<PlantAllDataDto>> getPlantByCategory(String category){
        List<Plant> plants = plantService.getPlantsByCategory(category);
        List<PlantAllDataDto> allPlants = new ArrayList<>();

        for(Plant plant : plants){
            allPlants.add(plantService.collectAllData(plant));
        }

        return new ResponseEntity<>(allPlants,HttpStatus.OK);
    }

    @GetMapping("/latest-limit")
    public ResponseEntity<List<Plant>> getLatestPostWithLimit(){
        return new ResponseEntity<>(plantService.getLatestPostWithLimit(),HttpStatus.OK);
    }


    @GetMapping("/sub-cat")
    public ResponseEntity<List<PlantAllDataDto>> getPlantBySubCategory(@RequestParam("category") List<String> category){
//        List<String> convertedToList = Arrays.asList(category.split(",", -1));
        List<Plant> plants = plantService.getPlantsBySubCategory(category);
        List<PlantAllDataDto> allPlants = new ArrayList<>();

        for(Plant plant : plants){
            allPlants.add(plantService.collectAllData(plant));
        }

        return new ResponseEntity<>(allPlants,HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity<Integer> savePlant(@RequestBody Plant plant,Principal user){
        return new ResponseEntity<>(plantService.savePlant(plant,user),HttpStatus.CREATED);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadPhoto(@RequestBody MultipartFile file,@RequestParam Integer id){
        plantService.uploadPhoto(file,id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    CALENDAR
    @GetMapping("/my-calendar")
    public ResponseEntity<List<MyCalendarDTO>> getCalendarInfoByObserved(Principal user){
        List<Plant> plants = plantService.getMyCalenderByEmail(user.getName());

        List<MyCalendarDTO> allPlants = new ArrayList<>();

        for(Plant plant : plants){
            allPlants.add(plantService.collectMyCalendar(plant));
        }

        return new ResponseEntity<>(allPlants,HttpStatus.OK);
    }

//    EVENT
    @GetMapping("/event/all")
    public ResponseEntity<List<Event>> getAllEvent(){
        return new ResponseEntity<>(plantService.findAllEvent(),HttpStatus.OK);
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

//    IMAGE
    @GetMapping("/image-by-plant-id")
    public ResponseEntity<Image> getImageByPlantId(@RequestParam Integer id){
        Image image = plantService.getImageByPlantIdLimit(id);
        return new ResponseEntity<>(image,HttpStatus.OK);
    }

}
