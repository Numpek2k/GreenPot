import {Component, Input, OnInit} from '@angular/core';
import {MessageService} from "../../services/message.service";
import {Message} from "../../models/message";
import {UserService} from "../../services/user.service";
import {User} from "../../models/user";
import {FormBuilder, Validators} from "@angular/forms";

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  constructor(private messageService: MessageService,
              private userService: UserService,
              private formBuilder: FormBuilder) { }

  @Input() id!:number
  messageForm = this.formBuilder.group({
    content:['',Validators.required],
    target:['',Validators.required]
  })
  messages?: Message[]
  loggedIn?: User

  ngOnInit(): void {
    this.messageService.getAllMessages(this.id).subscribe({
      next: value => this.messages = value
    })
    this.userService.getUser().subscribe({
      next: value => this.loggedIn = value
    })
    if(!this.loggedIn?.id)
      return;
  }

  ngOnChanges(): void{
    // this.userService.getUser().subscribe(value => this.loggedIn = value)
    this.messageService.getAllMessages(this.id).subscribe(value => this.messages = value)
    if(!this.loggedIn?.id)
      return;
  }

  onSendMessage(id: any): void {
    let content = this.messageForm.controls['content'].value;
    if(!content)
      return;

    let message: Message = {
      content: content
    }
    this.messageService.send(message,id);
    window.location.reload();
  }

  compareUser(mes: any): boolean{
    return JSON.stringify(this.loggedIn) === JSON.stringify(mes);
  }
}
