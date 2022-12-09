import { Component, OnInit } from '@angular/core';
import {User} from "../../models/user";
import {MessageService} from "../../services/message.service";

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit {

  constructor(private messageService: MessageService) { }


  receivers?: User[]
  id:any

  ngOnInit(): void {
    this.messageService.getAllReceivers().subscribe({
      next: value => {
        this.receivers = value
        this.id = value[0].id
      }
    })
  }

  onButtonClick(idUser: any): void {
    this.id = idUser
  }

}
