import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {RouterModule,Routes} from '@angular/router';

import {HttpModule} from '@angular/http';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { TopNavComponent } from './top-nav/top-nav.component';
import { LeftNavComponent } from './left-nav/left-nav.component';
import { MainContentComponent } from './main-content/main-content.component';
import { CentercomponentComponent } from './centercomponent/centercomponent.component';
import { RightcomponentComponent } from './rightcomponent/rightcomponent.component';
import { LogincomponentComponent } from './logincomponent/logincomponent.component';
import { FullpageComponent } from './fullpage/fullpage.component';

import { UserService } from './user.service';
import { AuthguardGuard } from './authguard.guard';
import {HelperService} from './helper.service';

import {FormsModule} from '@angular/forms';
import { BrokerUIComponent } from './broker-ui/broker-ui.component';
import { LeaderboardComponent } from './leaderboard/leaderboard.component';

const appRoutes:Routes = [
  {
    path:'',
    component:LogincomponentComponent
  },
  {
    path:'logincomponent',
    component:LogincomponentComponent
  },
  {
    path: 'fullpage',
    canActivate:[AuthguardGuard],
    component:FullpageComponent

  },
  {
    path:'broker-ui',
    component:BrokerUIComponent
  },
  {
    path:'fullpage/leaderBoard',
    component:LeaderboardComponent
  }
];


@NgModule({
  declarations: [
    AppComponent,
    TopNavComponent,
    LeftNavComponent,
    MainContentComponent,
    CentercomponentComponent,
    RightcomponentComponent,
    LogincomponentComponent,
    FullpageComponent,
    BrokerUIComponent,
    LeaderboardComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    HttpModule,
    FormsModule,
    HttpClientModule 
  ],
  providers: [UserService,AuthguardGuard,HelperService],
  bootstrap: [AppComponent]
})
export class AppModule { }
