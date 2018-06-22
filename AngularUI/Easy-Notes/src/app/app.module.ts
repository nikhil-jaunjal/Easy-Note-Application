import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule,Routes} from '@angular/router';
import{HttpModule} from '@angular/http';
import { AppComponent } from './app.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';

import{UserService} from './shared-service/user.service';
import { NoteService } from './shared-service/note.service';

const appRoutes: Routes=[
  {path:'dashboard',component: DashboardComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [UserService,NoteService],
  bootstrap: [AppComponent]
})
export class AppModule { }
