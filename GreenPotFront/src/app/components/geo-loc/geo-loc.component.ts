import {Component, ElementRef, NgZone, OnInit, ViewChild} from '@angular/core';
import {MapsAPILoader} from "@agm/core";
import {toNumbers} from "@angular/compiler-cli/src/version_helpers";

@Component({
  selector: 'app-geo-loc',
  templateUrl: './geo-loc.component.html',
  styleUrls: ['./geo-loc.component.css']
})
export class GeoLocComponent implements OnInit {
  title: string = 'AGM project';
  latitude!: number;
  longitude!: number;

  latitudeMark!: any;
  longitudeMark!: any;

  @ViewChild('search')
  public searchElementRef!: ElementRef;


  constructor(
    private mapsAPILoader: MapsAPILoader,
    private ngZone: NgZone
  ) { }


  ngOnInit() {
    //load Places Autocomplete
    this.mapsAPILoader.load().then(() => {
    });
    this.latitudeMark = Number(localStorage.getItem('latitude'));
    this.longitudeMark = Number(localStorage.getItem('longitude'));
    if(this.longitudeMark == undefined || this.latitudeMark == undefined) {
      this.latitude = 0
      this.longitude = 0
    }
    else{
      this.latitude = this.latitudeMark
      this.longitude = this.longitudeMark
    }

  }

  onMapClicked(event: any){
    console.table(event.coords);
    this.latitude = event.coords.lat;
    this.longitude = event.coords.lng;
    this.latitudeMark = this.latitude
    this.longitudeMark = this.longitude
    localStorage.setItem('latitude', this.latitude.toString())
    localStorage.setItem('longitude', this.longitude.toString())
  }


}
