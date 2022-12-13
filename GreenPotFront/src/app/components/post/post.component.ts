import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PlantService} from "../../services/plant.service";
import {Post} from "../../models/post";
import {Comment} from "../../models/comment";
import {PostService} from "../../services/post.service";
import {BASE_URL} from "../../utility/globals";
import {FormBuilder, Validators} from "@angular/forms";

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  constructor(private route: ActivatedRoute,
              private postService: PostService,
              private router: Router,
              private formBuilder: FormBuilder) { }


  id: any;
  post?: Post;
  comments?: Comment[]
  baseUrl = BASE_URL;
  commentForm = this.formBuilder.group({
      content: ['', Validators.required],
    }
  )

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    if(!Number.isInteger(parseInt(this.id))) {
      this.router.navigate(["/"])
      throw Error("Given value should be an integer")
    }
    this.postService.getPostById(parseInt(this.id)).subscribe({
      next: value => this.post = value,
      error: err => this.router.navigate(["/"])
    })
    this.postService.getCommentByPostId(parseInt(this.id)).subscribe({
      next: value => this.comments = value
    })
  }

  onSubmit(){
    if(!this.commentForm.valid) return;
    let content = this.commentForm.controls['content'].value as string;
    let comment: Comment = {
      content: content
    }
    this.postService.addCommentToPost(comment,this.post?.id as number).subscribe({
      complete: () => window.location.reload()
    });
  }


}
