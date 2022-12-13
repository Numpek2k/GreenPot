import {Component, Input, OnInit} from '@angular/core';
import {Post} from "../../models/post";
import {BASE_URL} from "../../utility/globals";

@Component({
  selector: 'app-card-holder-post',
  templateUrl: './card-holder-post.component.html',
  styleUrls: ['./card-holder-post.component.css']
})
export class CardHolderPostComponent implements OnInit {

  constructor() { }

  @Input() post!: Post

  baseUrl = BASE_URL
  contentHtml: any

  ngOnInit(): void {
  }

}
