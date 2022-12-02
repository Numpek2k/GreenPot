package com.example.greenpotback.Dto;

import com.example.greenpotback.Plant.Calendar.Calendar;
import com.example.greenpotback.Plant.Image.Image;
import com.example.greenpotback.Plant.Plant;
import com.example.greenpotback.Plant.SubCategory.SubCategory;
import lombok.Data;

import java.util.ArrayList;

@Data
public class PlantAllDataDto {
    Plant plant;
    ArrayList<SubCategory> subCategoriesList;
    ArrayList<Image> imagesList;
    ArrayList<Calendar> calendarList;
}
