package com.example.greenpotback.Dto;

import com.example.greenpotback.Plant.Calendar.Calendar;
import com.example.greenpotback.Plant.Plant;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MyCalendarDTO {
    Plant plant;
    List<Calendar> calendarList;
}
