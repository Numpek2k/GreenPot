package com.example.greenpotback.Dto;

import com.example.greenpotback.Plant.Calendar.Calendar;
import com.example.greenpotback.Plant.Image.Image;
import com.example.greenpotback.Plant.Plant;
import com.example.greenpotback.Plant.SubCategory.SubCategory;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlantAllDataDto {
    Plant plant;
    List<SubCategory> subCategoriesList;
    List<Image> imagesList;
    List<Calendar> calendarList;
}
