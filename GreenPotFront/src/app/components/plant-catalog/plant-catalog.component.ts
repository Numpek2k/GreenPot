import { Component, OnInit } from '@angular/core';
import {Category} from "../../models/category";
import {PlantService} from "../../services/plant.service";
import {CategoriesService} from "../../services/categories.service";
import {PlantAllDataDto} from "../../dto/plantAllDataDto";
import {SubCategory} from "../../models/subCategory";


interface filterSubCat{
  id?:number
  name:string;
  checked?:boolean;
}


@Component({
  selector: 'app-plant-catalog',
  templateUrl: './plant-catalog.component.html',
  styleUrls: ['./plant-catalog.component.css']
})
export class PlantCatalogComponent implements OnInit {

  constructor(private categoryService: CategoriesService,
              private plantService: PlantService) { }

  mainCategories?: Category[]
  allPlant?: PlantAllDataDto[]
  filterArray!: filterSubCat[]

  ngOnInit(): void {

    this.plantService.getAllPlants().subscribe({
      next: value => this.allPlant = value
    })

    this.categoryService.getAllMainCategories().subscribe({
      next: category => this.mainCategories = category
    })

    this.categoryService.getAllSubCategories().subscribe({
      next: value => {
        this.filterArray = value
      }
    })

  }

  changePlantCategory(cat: string) {
    if (cat === 'all')
      this.plantService.getAllPlants().subscribe({
        next: value => this.allPlant = value
      })
    this.plantService.getPlantByMainCategory(cat).subscribe({
      next: value => this.allPlant = value
    })
  }

  selectedOptions() {
    if(!this.filterArray) return;
    this.filterArray
      .filter(cat => cat.checked)
      .map(cat => cat.name)
  }

  getPlantsBySubCat(){
    let checkedFilters = this.filterArray.filter(cat => cat.checked === true)
    let filterToString = ''
    if(checkedFilters.length === 0) return;

    for(let filter of checkedFilters)
      filterToString += filter.name + ','

    this.plantService.getPlantBySubCategory(filterToString.substring(0, filterToString.length - 1)).subscribe({
      next: value => this.allPlant = value
    })
  }


}
