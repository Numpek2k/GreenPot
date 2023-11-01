import {ChangeDetectorRef, Component, OnInit} from '@angular/core';
import {Plant} from "../../models/plant";
import {Post} from "../../models/post";
import {PostService} from "../../services/post.service";
import {PlantService} from "../../services/plant.service";
import {WeatherService} from "../../services/weather.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private postService: PostService,
              private plantService: PlantService,
              private weatherService: WeatherService,
              private cd: ChangeDetectorRef) { }


  plants?: Plant[]
  posts?: Post[]
  latitude: any = ''
  longitude: any = ''
  dailyData: any

  ngOnInit(): void {
    this.postService.getLatestPostWithLimit().subscribe({
      next: value => this.posts = value
    })
    this.plantService.getLatestPlantWithLimit().subscribe({
      next: value => this.plants = value
    })
    this.longitude = localStorage.getItem('longitude')
    this.latitude = localStorage.getItem('latitude')

    if(this.longitude == undefined || this.latitude == undefined) {
      this.latitude = 0
      this.longitude = 0
    }

    this.weatherService.getWeatherForecast(this.latitude,this.longitude).subscribe({
      next: value => {
        this.dailyData = value.daily
        this.cd.detectChanges()
      }
    })
  }

  getDayFromDate(date: number): string{
    const weekday = ["Sun","Mon","Tues","Wed","Thurs","Fri","Sat"];
    let setDate = new Date(date*1000)
    return weekday[setDate.getDay()]
  }

  getWeatherIcon(data: any): string {
    if (data.weather.length > 0) {
      const icon = data.weather[0].icon
      return `assets/weather-icon/${icon}.svg`
    } else {
      return ''
    }
  }


}
