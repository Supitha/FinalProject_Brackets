import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { TopNavComponent } from './top-nav/top-nav.component';
import { LeftNavComponent } from './left-nav/left-nav.component';
import { MainContentComponent } from './main-content/main-content.component';
import { CentercomponentComponent } from './centercomponent/centercomponent.component';
import { RightcomponentComponent } from './rightcomponent/rightcomponent.component';
import { LogincomponentComponent } from './logincomponent/logincomponent.component';

@NgModule({
  declarations: [
    AppComponent,
    TopNavComponent,
    LeftNavComponent,
    MainContentComponent,
    CentercomponentComponent,
    RightcomponentComponent,
    LogincomponentComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
