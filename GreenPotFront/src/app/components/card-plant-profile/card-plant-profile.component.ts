import {Component, Input, OnInit} from '@angular/core';
import {Plant} from "../../models/plant";
import {BASE_URL} from "../../utility/globals";
import {PlantService} from "../../services/plant.service";
import {Image} from "../../models/image";

@Component({
  selector: 'app-card-plant-profile',
  templateUrl: './card-plant-profile.component.html',
  styleUrls: ['./card-plant-profile.component.css']
})
export class CardPlantProfileComponent implements OnInit {

  constructor(private plantService: PlantService) { }

  @Input() plant!: Plant
  image?: Image
  baseUrl = BASE_URL

  ngOnInit(): void {
    if(!this.plant.id) return;
    this.plantService.getImageByPlantIdLimit1(this.plant.id).subscribe({
      next: value => this.image = value
    })
  }

}
