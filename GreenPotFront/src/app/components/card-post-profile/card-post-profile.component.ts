import {Component, Input, OnInit} from '@angular/core';
import {Plant} from "../../models/plant";
import {Image} from "../../models/image";
import {BASE_URL} from "../../utility/globals";
import {Post} from "../../models/post";

@Component({
  selector: 'app-card-post-profile',
  templateUrl: './card-post-profile.component.html',
  styleUrls: ['./card-post-profile.component.css']
})
export class CardPostProfileComponent implements OnInit {

  constructor() { }

  @Input() post!: Post
  baseUrl = BASE_URL

  ngOnInit(): void {
  }

}
