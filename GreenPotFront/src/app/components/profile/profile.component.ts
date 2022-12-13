import { Component, OnInit } from '@angular/core';
import {UserService} from "../../services/user.service";
import {PlantService} from "../../services/plant.service";
import {User} from "../../models/user";
import {ActivatedRoute, Router} from "@angular/router";
import {Plant} from "../../models/plant";
import {Post} from "../../models/post";
import {PostService} from "../../services/post.service";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(private userService: UserService,
              private plantService: PlantService,
              private postService: PostService,
              private router: Router,
              private route: ActivatedRoute) { }

  user?: User
  plants?: Plant[]
  posts?: Post[]
  id: any
  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    if(!Number.isInteger(parseInt(this.id))) {
      this.router.navigate(["/"])
      throw Error("Given value should be an integer")
    }
    this.userService.getUserById(this.id).subscribe({
      next: value => {
        this.user = value
      },
      error: err => {
        if(err.status == 404){
          this.router.navigate(["/"])
          throw Error(err.status)
        }
      }
    })
    this.plantService.getPlantByAuthor(this.id).subscribe({
      next: value => this.plants = value,
      error: err => {
        if(err.status == 404){
          this.router.navigate(["/"])
          throw Error(err.status)
        }
      }
    })

    this.postService.getPostByAuthor(this.id).subscribe({
      next: value => this.posts = value
    })

  }



}
