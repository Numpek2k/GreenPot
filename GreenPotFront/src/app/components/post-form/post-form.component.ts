import { Component, OnInit } from '@angular/core';
import {FormArray, FormBuilder, FormGroup, UntypedFormBuilder, Validators} from "@angular/forms";
import {HttpEventType} from "@angular/common/http";
import {PostService} from "../../services/post.service";
import {Post} from "../../models/post";
import {Router} from "@angular/router";

@Component({
  selector: 'app-post-form',
  templateUrl: './post-form.component.html',
  styleUrls: ['./post-form.component.css']
})
export class PostFormComponent implements OnInit {

  constructor(private formBuilder:FormBuilder,
              private postService: PostService,
              private router: Router) {
  }

  postForm!: FormGroup;
  selectedFile!: File;
  errorMessage = '';
  postId!: number;
  progressInfos: any;

  ngOnInit(): void {
    this.postForm = this.formBuilder.group({
      title: ['',{validators:[Validators.required,Validators.minLength(3),Validators.maxLength(255)], updateOn: 'blur'}],
      contentArray: this.formBuilder.array([]) ,
    });
  }

  onSubmit() {

    if(!this.postForm.valid) {
      this.errorMessage='Make sure every input is filled'
      return;
    }

    if(!this.selectedFile) {
      this.errorMessage = 'You need to submit at least 1 photo'
      return;
    }

    const post = {} as Post

    post.title = this.title.value
    post.content = this.contentArrayToStringBuilder()
    this.postService.savePost(post).subscribe({
      next: value => {
        this.postId = value
        this.uploadFile();
      }
    })
  }

  contentArrayToStringBuilder(): string {
    let content = ''
    const array = this.contentArray().value
    for(let data of array) {
      content += '<h3 class="mt-2">' + data.subTitle + '</h3>'
      content += '<span>' + data.content + '</span>'
    }
    return content;
  }
  contentArray() : FormArray {
    return this.postForm.get("contentArray") as FormArray
  }

  newQuantity(): FormGroup {
    return this.formBuilder.group({
      subTitle: ['',{validators:[Validators.required,Validators.minLength(3),Validators.maxLength(255)], updateOn: 'blur'}],
      content: ['',{validators:[Validators.required,Validators.minLength(3)], updateOn: 'blur'}],
    })
  }

  addQuantity() {
    this.contentArray().push(this.newQuantity());
  }

  removeQuantity(i:number) {
    this.contentArray().removeAt(i);
  }

  selectFile(event: any) {
    this.progressInfos = [];
    this.selectedFile = event.target.files;
  }

  upload(file: any) {
    this.progressInfos = { value: 0, fileName: file.name };

    this.postService.upload(file[0],this.postId).subscribe({
      next: event =>{
        if (event.type === HttpEventType.UploadProgress) {
          if(!event.total) return;
          this.progressInfos.value = Math.round(100 * event.loaded / event.total);
        }
      },
      error: err => {
        this.progressInfos.value = 0;
        this.errorMessage = 'Could not upload the file:' + file[0].name;
      },
      complete: () => this.router.navigate(['/plant/'+this.postId])
    });
  }

  uploadFile() {
    this.errorMessage = '';
    this.upload(this.selectedFile);
  }

  get title(){
    return this.postForm.controls['title']
  }

}
