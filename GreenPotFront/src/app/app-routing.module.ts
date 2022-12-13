import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RegisterComponent} from "./components/register/register.component";
import {LoginComponent} from "./components/login/login.component";
import {PlantComponent} from "./components/plant/plant.component";
import {PlantCatalogComponent} from "./components/plant-catalog/plant-catalog.component";
import {MyCalendarComponent} from "./components/my-calendar/my-calendar.component";
import {ProfileComponent} from "./components/profile/profile.component";
import {ChatComponent} from "./components/chat/chat.component";
import {PlantFormComponent} from "./components/plant-form/plant-form.component";
import {PostFormComponent} from "./components/post-form/post-form.component";
import {PostContainerComponent} from "./components/post-container/post-container.component";
import {PostService} from "./services/post.service";
import {PostComponent} from "./components/post/post.component";
import {HomeComponent} from "./components/home/home.component";


const routes: Routes = [
  {path: 'register',component: RegisterComponent},
  {path: 'login',component: LoginComponent},
  {path: 'plant/:id',component: PlantComponent},
  {path: 'catalog',component: PlantCatalogComponent},
  {path: 'calendar',component: MyCalendarComponent},
  {path: 'profile/:id',component: ProfileComponent},
  {path: 'chat',component: ChatComponent},
  {path: 'add-plant',component: PlantFormComponent},
  {path: 'add-post',component: PostFormComponent},
  {path: 'posts',component: PostContainerComponent},
  {path: 'post/:id',component: PostComponent},
  {path: 'home',component: HomeComponent},
  { path: '', redirectTo: '/home', pathMatch: 'full' }
  // { path: '', component:  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
