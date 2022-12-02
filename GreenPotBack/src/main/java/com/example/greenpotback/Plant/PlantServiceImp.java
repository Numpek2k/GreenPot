package com.example.greenpotback.Plant;

import com.example.greenpotback.Plant.Calendar.Calendar;
import com.example.greenpotback.Plant.Calendar.CalendarRepository;
import com.example.greenpotback.Plant.Image.Image;
import com.example.greenpotback.Plant.Image.ImageRepository;
import com.example.greenpotback.Plant.SubCategory.SubCategory;
import com.example.greenpotback.Plant.SubCategory.SubCategoryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlantServiceImp implements PlantService {

    private final PlantRepository plantRepository;

    private final SubCategoryRepository subCategoryRepository;

    private final ImageRepository imageRepository;

    private final CalendarRepository calendarRepository;

    @Override
    public Plant findPlantByID(Integer id) {
        return plantRepository.findPlantById(id);
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
        return calendarRepository.findAllByPlantId(id);
    }
}
