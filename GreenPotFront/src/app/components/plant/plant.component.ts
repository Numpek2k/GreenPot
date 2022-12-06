import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PlantService} from "../../services/plant.service";
import {PlantAllDataDto} from "../../dto/plantAllDataDto";
import {BASE_URL} from "../../utility/globals";
import {Calendar} from "../../models/calendar";

@Component({
  selector: 'app-plant',
  templateUrl: './plant.component.html',
  styleUrls: ['./plant.component.css']
})
export class PlantComponent implements OnInit {

  constructor(private route: ActivatedRoute,
              private plantService: PlantService,
              private router: Router) { }

  private id: any;
  allData?: PlantAllDataDto;
  baseUrl: any;

  ngOnInit(): void {
    this.baseUrl=BASE_URL

    this.id = this.route.snapshot.paramMap.get('id');
    if(!Number.isInteger(parseInt(this.id))) {
      this.router.navigate(["/"])
      throw Error("Given value should be an integer")
    }


    this.plantService.getAllDataPlantById(parseInt(this.id)).subscribe({
      next: value => {
        for(let cal of value.calendarList)
          this.trimDates(cal)
        this.allData = value
      },
      error: err => this.router.navigate(["/"])
    });

  }

  trimDates(calendar: Calendar) {
    calendar.dateStart = calendar.dateStart.substring(5, 10)
    calendar.dateEnd = calendar.dateEnd.substring(5, 10)
  }

}
