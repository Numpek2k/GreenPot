import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {RegisterComponent} from "./components/register/register.component";
import {LoginComponent} from "./components/login/login.component";
import {PlantComponent} from "./components/plant/plant.component";
import {PlantCatalogComponent} from "./components/plant-catalog/plant-catalog.component";
import {MyCalendarComponent} from "./components/my-calendar/my-calendar.component";
import {ProfileComponent} from "./components/profile/profile.component";
import {ChatComponent} from "./components/chat/chat.component";


const routes: Routes = [
  {path: 'register',component: RegisterComponent},
  {path: 'login',component: LoginComponent},
  {path: 'plant/:id',component: PlantComponent},
  {path: 'catalog',component: PlantCatalogComponent},
  {path: 'calendar',component: MyCalendarComponent},
  {path: 'profile/:id',component: ProfileComponent},
  {path: 'chat',component: ChatComponent},
  // { path: '', redirectTo: '/something', pathMatch: 'full' }
  // { path: '', component:  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
