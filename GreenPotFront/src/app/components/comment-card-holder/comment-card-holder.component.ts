import {Component, Input, OnInit} from '@angular/core';
import {Comment} from "../../models/comment";

@Component({
  selector: 'app-comment-card-holder',
  templateUrl: './comment-card-holder.component.html',
  styleUrls: ['./comment-card-holder.component.css']
})
export class CommentCardHolderComponent implements OnInit {

  constructor() { }

  @Input() comment!: Comment

  ngOnInit(): void {
  }

}
