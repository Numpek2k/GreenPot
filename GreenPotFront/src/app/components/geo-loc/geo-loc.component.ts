import {Component, ElementRef, NgZone, OnInit, ViewChild} from '@angular/core';
import {MapsAPILoader} from "@agm/core";

@Component({
  selector: 'app-geo-loc',
  templateUrl: './geo-loc.component.html',
  styleUrls: ['./geo-loc.component.css']
})
export class GeoLocComponent implements OnInit {
  title: string = 'AGM project';
  latitude!: number;
  longitude!: number;

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
  }

  onMapClicked(event: any){
    console.table(event.coords);
    this.latitude = event.coords.lat;
    this.longitude = event.coords.lng;
    localStorage.setItem('latitude', this.latitude.toString())
    localStorage.setItem('longitude', this.longitude.toString())
  }


}
