import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PlantService} from "../../services/plant.service";
import {PlantAllDataDto} from "../../dto/plantAllDataDto";

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

  ngOnInit(): void {

    this.id = this.route.snapshot.paramMap.get('id');
    if(!Number.isInteger(parseInt(this.id))) {
      this.router.navigate(["/"])
      throw Error("Given value should be an integer")
    }


    this.plantService.getAllDataPlantById(parseInt(this.id)).subscribe({
      next: data => this.allData = data,
      error: err => this.router.navigate(["/"])
    });

  }

}
