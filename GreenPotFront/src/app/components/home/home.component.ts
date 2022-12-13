import { Component, OnInit } from '@angular/core';
import {Plant} from "../../models/plant";
import {Post} from "../../models/post";
import {PostService} from "../../services/post.service";
import {PlantService} from "../../services/plant.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private postService: PostService,
              private plantService: PlantService) { }


  plants?: Plant[]
  posts?: Post[]

  ngOnInit(): void {
    this.postService.getLatestPostWithLimit().subscribe({
      next: value => this.posts = value
    })
    this.plantService.getLatestPlantWithLimit().subscribe({
      next: value => this.plants = value
    })
  }

}
