package com.example.greenpotback.Plant;

import com.example.greenpotback.Controllers.ControllerConst;
import com.example.greenpotback.Dto.MyCalendarDTO;
import com.example.greenpotback.Dto.PlantAllDataDto;
import com.example.greenpotback.Plant.Calendar.Calendar;
import com.example.greenpotback.Plant.Calendar.CalendarRepository;
import com.example.greenpotback.Plant.Calendar.Event.Event;
import com.example.greenpotback.Plant.Calendar.Event.EventRepository;
import com.example.greenpotback.Plant.Image.Image;
import com.example.greenpotback.Plant.Image.ImageRepository;
import com.example.greenpotback.Plant.MainCategory.MainCategory;
import com.example.greenpotback.Plant.MainCategory.MainCategoryRepository;
import com.example.greenpotback.Plant.SubCategory.SubCategory;
import com.example.greenpotback.Plant.SubCategory.SubCategoryRepository;
import com.example.greenpotback.User.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.Principal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.nio.file.Path;

@Service
@AllArgsConstructor
public class PlantServiceImp implements PlantService {

    private final PlantRepository plantRepository;
    private final MainCategoryRepository mainCategoryRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final ImageRepository imageRepository;
    private final CalendarRepository calendarRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final EntityManager entityManager;

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
    public List<Plant> getPlantsByAuthor(Integer id) {
        return plantRepository.findAllByAuthorId(id);
    }

    @Override
    @Transactional
    public Integer savePlant(Plant plant, Principal user) {
        plant.setCategory(mainCategoryRepository.findByName(plant.getCategory().getName()));
        plant.setAuthor(userRepository.findUserByEmail(user.getName()));
        Set<String> subCat = new HashSet<>();
        for(SubCategory cat : plant.getSubCategories())
            subCat.add(cat.getName());
        plant.setSubCategories(subCategoryRepository.findAllByNameIn(subCat));
        for(Calendar cal : plant.getCalendar()){
            cal.setEvent(eventRepository.findByName(cal.getEvent().getName()));
            cal.setPlant(plant);
        }
        plant.setCalendar(plant.getCalendar());
        entityManager.persist(plant);
        return plant.getId();
    }

    @Override
    public void uploadPhoto(MultipartFile file, Integer id) {
        Path uploadPath = Paths.get(ControllerConst.PLANT_IMAGE_SAVE_PATH + id);
        Image img = new Image();

        if (!Files.exists(uploadPath)) {
            try {
                Files.createDirectories(uploadPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String fileName = new Date().getTime() + file.getOriginalFilename();

        try (InputStream inputStream = file.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        img.setFilePath(ControllerConst.PLANT_IMAGES_PATH+fileName);
        img.setPlant(plantRepository.findPlantById(id));

        imageRepository.save(img);
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
    public Image getImageByPlantIdLimit(Integer id) {
        Image image = imageRepository.getFirstImageByPlantId(id);
        image.setFilePath(ControllerConst.PLANT_IMAGES_PATH + id + "/" + image.getFilePath());
        return image;
    }

    @Override
    public List<Calendar> findAllCalendarByPlantId(Integer id) {
        return calendarRepository.findAllByPlantIdOrderByDateStart(id);
    }

    @Override
    public List<Event> findAllEvent() {
        return eventRepository.findAll();
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
