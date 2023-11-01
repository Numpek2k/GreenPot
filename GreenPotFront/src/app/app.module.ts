import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { AppRoutingModule } from './app-routing.module';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { PlantComponent } from './components/plant/plant.component';
import { FooterComponent } from './components/footer/footer.component';
import {TokenInterceptorService} from "./interceptors/token-interceptor.service";
import { CardHolderPlantComponent } from './components/card-holder-plant/card-holder-plant.component';
import { PlantCatalogComponent } from './components/plant-catalog/plant-catalog.component';
import { MyCalendarComponent } from './components/my-calendar/my-calendar.component';
import { DateProgressBarComponent } from './components/date-progress-bar/date-progress-bar.component';
import { ButtonFollowComponent } from './components/button-follow/button-follow.component';
import { ProfileComponent } from './components/profile/profile.component';
import { CardPlantProfileComponent } from './components/card-plant-profile/card-plant-profile.component';
import { ChatComponent } from './components/chat/chat.component';
import { MessagesComponent } from './components/messages/messages.component';
import { PlantFormComponent } from './components/plant-form/plant-form.component';
import { PostFormComponent } from './components/post-form/post-form.component';
import { PostContainerComponent } from './components/post-container/post-container.component';
import { CardHolderPostComponent } from './components/card-holder-post/card-holder-post.component';
import { PostComponent } from './components/post/post.component';
import { CardPostProfileComponent } from './components/card-post-profile/card-post-profile.component';
import { HomeComponent } from './components/home/home.component';
import {CommentCardHolderComponent} from "./components/comment-card-holder/comment-card-holder.component";
import { AgmCoreModule } from '@agm/core';
import { GeoLocComponent } from './components/geo-loc/geo-loc.component';
import {StompService} from "./services/stomp.service";
import {stompServiceFactory} from "./services/stompServiceFactory";

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    RegisterComponent,
    LoginComponent,
    PlantComponent,
    FooterComponent,
    CardHolderPlantComponent,
    PlantCatalogComponent,
    MyCalendarComponent,
    DateProgressBarComponent,
    ButtonFollowComponent,
    ProfileComponent,
    CardPlantProfileComponent,
    ChatComponent,
    MessagesComponent,
    PlantFormComponent,
    PostFormComponent,
    PostContainerComponent,
    CardHolderPostComponent,
    PostComponent,
    CommentCardHolderComponent,
    CardPostProfileComponent,
    HomeComponent,
    GeoLocComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyAyA9R7skWBGZuqg_jmkWIHMO7Mr7lqVy4',
      libraries: ['places']
    })
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptorService,
      multi: true,
    },
    {
      provide: StompService,
      useFactory: stompServiceFactory,
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
