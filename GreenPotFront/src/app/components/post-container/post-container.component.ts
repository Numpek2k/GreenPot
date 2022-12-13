import { Component, OnInit } from '@angular/core';
import {PostService} from "../../services/post.service";
import {Post} from "../../models/post";

@Component({
  selector: 'app-post-container',
  templateUrl: './post-container.component.html',
  styleUrls: ['./post-container.component.css']
})
export class PostContainerComponent implements OnInit {

  constructor(private postService: PostService) { }

  postArray?: Post[]

  ngOnInit(): void {
    this.postService.getAllPosts().subscribe({
      next: value => this.postArray = value
    })
  }

}
