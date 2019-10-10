import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FooterComponent } from './footer/footer.component';
import { NewsfeedComponent } from './newsfeed/newsfeed.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AccountDropdownComponent } from './account-dropdown/account-dropdown.component';
import { TopNewsComponent } from './top-news/top-news.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    FooterComponent,
    NewsfeedComponent,
    SidebarComponent,
    NavbarComponent,
    AccountDropdownComponent,
    TopNewsComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
