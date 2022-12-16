import {Component, Input, OnInit} from '@angular/core';
import {MessageService} from "../../services/message.service";
import {MyMessage} from "../../models/myMessage";
import {UserService} from "../../services/user.service";
import {User} from "../../models/user";
import {FormBuilder, Validators} from "@angular/forms";
import {StompService} from "../../services/stomp.service";
import {Message} from "@stomp/stompjs";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  constructor(private messageService: MessageService,
              private userService: UserService,
              private formBuilder: FormBuilder,
              private stompService: StompService) { }

  @Input() id!:number
  messageForm = this.formBuilder.group({
    content:['',Validators.required],
    target:['',Validators.required]
  })
  messages?: MyMessage[]
  loggedIn?: User
  watcher?: string = ''
  private subscription?: Subscription;

  ngOnInit(): void {

    this.messageService.getAllMessages(this.id).subscribe({
      next: value => {
        this.messages = value
      }
    })
    // this.userService.getUser().subscribe({
    //   next: value => this.loggedIn = value
    // })
    // if(!this.loggedIn?.id)
    //   return;
  }

  ngOnChanges(): void{
    this.userService.getUser().subscribe(value => {
      this.loggedIn = value
      this.subscription?.unsubscribe()
      this.watcher = ''
      let stomp = this.stompService.watch("/topic/messages/" + this.loggedIn?.id)
      this.subscription = stomp.subscribe({
        next: value => this.watcher += JSON.parse(value.body).content
      })
    })

    this.messageService.getAllMessages(this.id).subscribe(value => this.messages = value)
    // this.subscription?.unsubscribe()
    if(!this.loggedIn?.id)
      return;
  }

  onSendMessage(id: any): void {
    let content = this.messageForm.controls['content'].value;
    if(!content)
      return;

    let message: MyMessage = {
      content: content
    }
    this.messageService.send(message,id);
    window.location.reload();
  }

  compareUser(mes: any): boolean{
    return JSON.stringify(this.loggedIn) === JSON.stringify(mes);
  }

  onSendMessages(){
    console.log("hello")
    const message: MyMessage = {
      content: this.messageForm.get('content')?.value as string
    }
    console.log( JSON.stringify(message))
    this.stompService.publish({destination:"/app/chat/"+this.loggedIn?.id+"/"+ this.id,body: JSON.stringify(message)})
  }

  ngOnDestroy(){
    this.subscription?.unsubscribe()
  }

}
