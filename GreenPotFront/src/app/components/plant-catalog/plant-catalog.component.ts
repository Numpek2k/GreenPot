import { Component, OnInit } from '@angular/core';
import {Category} from "../../models/category";
import {PlantService} from "../../services/plant.service";
import {CategoriesService} from "../../services/categories.service";
import {PlantAllDataDto} from "../../dto/plantAllDataDto";
import {SubCategory} from "../../models/subCategory";

@Component({
  selector: 'app-plant-catalog',
  templateUrl: './plant-catalog.component.html',
  styleUrls: ['./plant-catalog.component.css']
})
export class PlantCatalogComponent implements OnInit {

  constructor(private categoryService: CategoriesService,
              private plantService: PlantService) { }

  mainCategories?: Category[]
  subCategories?: SubCategory[]
  allPlant?: PlantAllDataDto[]

  ngOnInit(): void {

    this.categoryService.getAllMainCategories().subscribe({
      next: category => this.mainCategories = category
    })

    this.categoryService.getAllSubCategories().subscribe({
      next: value => this.subCategories = value
    })

    this.plantService.getAllPlants().subscribe({
      next: value => this.allPlant = value
    })

  }

  changePlantCategory(cat: string){
    if(cat === 'all')
      this.plantService.getAllPlants().subscribe({
        next: value => this.allPlant = value
      })
    this.plantService.getPlantByMainCategory(cat).subscribe({
      next: value => this.allPlant = value
    })
  }

}
