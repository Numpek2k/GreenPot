import {Component, Input, OnInit} from '@angular/core';
import {PlantAllDataDto} from "../../dto/plantAllDataDto";
import {Image} from "../../models/image";
import {BASE_URL} from "../../utility/globals";

@Component({
  selector: 'app-card-holder-plant',
  templateUrl: './card-holder-plant.component.html',
  styleUrls: ['./card-holder-plant.component.css']
})
export class CardHolderPlantComponent implements OnInit {

  constructor() { }

  @Input() allData!: PlantAllDataDto
  image?: Image
  baseUrl: any

  ngOnInit(): void {
    this.baseUrl = BASE_URL
    this.image = this.allData.imagesList.pop();
  }

}
