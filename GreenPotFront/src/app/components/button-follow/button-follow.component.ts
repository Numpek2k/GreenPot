import {Component, Input, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-button-follow',
  templateUrl: './button-follow.component.html',
  styleUrls: ['./button-follow.component.css']
})
export class ButtonFollowComponent implements OnInit {

  constructor(private userService: UserService) { }

  @Input() plantId!: number;
  isFav: any;

  ngOnInit(): void {
    this.userService.isUserFollowingPlant(this.plantId).subscribe({
      next: value => this.isFav = value
    })
  }

  public toggleSelected() {
    if(this.isFav){
      this.userService.unFollowPlant(this.plantId).subscribe({
       next: value => this.isFav = value
      })
    }
    else{
      this.userService.followPlant(this.plantId).subscribe({
        next: value => this.isFav = value
      })
    }
  }



}
