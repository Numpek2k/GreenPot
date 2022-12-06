import { Component, OnInit } from '@angular/core';
import {PlantService} from "../../services/plant.service";
import {MyCalendarDTO} from "../../dto/MyCalendarDTO";

@Component({
  selector: 'app-my-calendar',
  templateUrl: './my-calendar.component.html',
  styleUrls: ['./my-calendar.component.css']
})
export class MyCalendarComponent implements OnInit {

  constructor(private plantService: PlantService) { }

  myCalendar?: MyCalendarDTO[]

  ngOnInit(): void {
    this.plantService.getMyCalender().subscribe({
      next: value => {this.myCalendar = value}
    })
  }

}
