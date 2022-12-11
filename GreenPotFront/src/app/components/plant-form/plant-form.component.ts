import {Component, OnInit} from '@angular/core';
import {FormArray, FormControl, UntypedFormBuilder, Validators} from "@angular/forms";
import {CategoriesService} from "../../services/categories.service";
import {SubCategory} from "../../models/subCategory";
import {Category} from "../../models/category";
import {PlantService} from "../../services/plant.service";
import {Events} from "../../models/events";
import * as events from "events";
import {Calendar} from "../../models/calendar";
import {HttpEventType} from "@angular/common/http";
import {Plant} from "../../models/plant";

@Component({
  selector: 'app-plant-form',
  templateUrl: './plant-form.component.html',
  styleUrls: ['./plant-form.component.css']
})
export class PlantFormComponent implements OnInit {

  constructor(private _formBuilder: UntypedFormBuilder,
              private categoryService: CategoriesService,
              private plantService: PlantService) { }

  plantAddForm = this._formBuilder.group({
    name: ['',{validators:[Validators.required,Validators.minLength(3),Validators.maxLength(255)], updateOn: 'blur'}],
    description: ['',{validators:[Validators.required,Validators.minLength(3),Validators.maxLength(255)], updateOn: 'blur'}],
    requirements: ['',{validators:[Validators.required,Validators.minLength(3),Validators.maxLength(255)], updateOn: 'blur'}],
    planting: ['',{validators:[Validators.required,Validators.minLength(3),Validators.maxLength(255)], updateOn: 'blur'}],
    growing: ['',{validators:[Validators.required,Validators.minLength(3),Validators.maxLength(255)], updateOn: 'blur'}],
    mainCategory: ['',{validators:[Validators.required], updateOn: 'blur'}],
    subCategories: this._formBuilder.array([],{validators:[Validators.required,Validators.minLength(2)], updateOn: 'blur'}),
    events: this._formBuilder.array([],{validators:[Validators.required], updateOn: 'blur'}),
  })

  subCatArray?: SubCategory[]
  mainCategories?: Category[]
  eventArray?: Events[]
  currYear = new Date().getFullYear()
  selectedFiles!: FileList;
  progressInfos: any[] = [];
  errorMessage = '';
  plantId!: number;

  ngOnInit(): void {

    this.categoryService.getAllSubCategories().subscribe({
      next: value => {
        this.subCatArray = value
      }
    })

    this.categoryService.getAllMainCategories().subscribe({
      next: value => this.mainCategories = value
    })

    this.plantService.getAllEvents().subscribe({
      next: value => this.eventArray = value
    })
  }

  onSubmitForm(){

    if(!this.plantAddForm.valid)
      return;

    if(!this.selectedFiles || this.selectedFiles.length == 0) {
      this.errorMessage = 'You need to submit at least 1 photo'
      return;
    }

    const plant = {} as Plant
    const cat = {} as Category
    const subCat: Array<SubCategory> = [];
    let chosenEv = this.plantAddForm.get('events')?.value

    cat.name = this.mainCategory.value
    for(let sub of this.subCategories.value) {
      let cat = {} as SubCategory
      cat.name = sub
      subCat.push(cat)
    }
    plant.name = this.name.value
    plant.description = this.description.value
    plant.requirements = this.requirements.value
    plant.planting = this.planting.value
    plant.growing = this.growing.value
    plant.category = cat
    plant.subCategories = subCat
    plant.calendar = this.getDateOfChosenEvent(chosenEv);

    this.plantService.savePlant(plant).subscribe({
      next: value => {
        this.plantId = value
        this.uploadFiles()
      }
    })
  }

  onSubCatChange(e: any) {
    const checkArray: FormArray = this.plantAddForm.get('subCategories') as FormArray;
    this.pushToArray(e,checkArray)
  }

  onEventChange(e: any) {
    const checkArray: FormArray = this.plantAddForm.get('events') as FormArray;
    this.pushToArray(e,checkArray)
  }

  pushToArray(e:any, checkArray: any){
    if (e.target.checked) {
      checkArray.push(new FormControl(e.target.value));
    } else {
      let i: number = 0;
      checkArray.controls.forEach((item: any) => {
        if (item.value == e.target.value) {
          checkArray.removeAt(i);
          return;
        }
        i++;
      });
    }
  }

  getDateOfChosenEvent(chosen: any): Calendar[] | undefined{
    if(!chosen) return;
    let calenderObj: Array<Calendar> = [];
    for(let ev of chosen){
      let event = {} as Events
      let cal = {} as Calendar
      event.name = ev
      cal.event = event
      cal.dateStart = (<HTMLInputElement>document.getElementById(ev+"Start")).value
      cal.dateEnd = (<HTMLInputElement>document.getElementById(ev+"End")).value
      calenderObj.push(cal)
    }
    return calenderObj;
  }

  selectFiles(event: any) {
    this.progressInfos = [];
    this.selectedFiles = event.target.files;
  }

  upload(idx: number, file: any) {
    this.progressInfos[idx] = { value: 0, fileName: file.name };

    this.plantService.upload(file,this.plantId).subscribe(
      event => {
        if (event.type === HttpEventType.UploadProgress) {
          if(!event.total) return;
          this.progressInfos[idx].value = Math.round(100 * event.loaded / event.total);
        }
      },
      err => {
        this.progressInfos[idx].value = 0;
        this.errorMessage = 'Could not upload the file:' + file.name;
      });
  }

  uploadFiles() {
    this.errorMessage = '';

    for (let i = 0; i < this.selectedFiles.length; i++) {
      this.upload(i, this.selectedFiles[i]);
    }
  }

  get name(){
    return this.plantAddForm.controls['name']
  }
  get description(){
    return this.plantAddForm.controls['description']
  }
  get requirements(){
    return this.plantAddForm.controls['requirements']
  }
  get planting(){
    return this.plantAddForm.controls['planting']
  }
  get growing(){
    return this.plantAddForm.controls['growing']
  }
  get mainCategory(){
    return this.plantAddForm.controls['mainCategory']
  }
  get subCategories(){
    return this.plantAddForm.controls['subCategories']
  }



}
