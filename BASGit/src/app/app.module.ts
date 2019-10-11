import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FooterComponent } from './footer/footer.component';
import { NewsfeedComponent } from './newsfeed/newsfeed.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AccountDropdownComponent } from './account-dropdown/account-dropdown.component';
import { TopNewsComponent } from './top-news/top-news.component';
import { AppRoutingModule } from './app-routing.module';
import { UserNewsComponent } from './user-news/user-news.component';
import { SidebarProfileComponent } from './sidebar-profile/sidebar-profile.component';
import { SidebarUserNewsComponent } from './sidebar-user-news/sidebar-user-news.component';
import { ProfilePageComponent } from './profile-page/profile-page.component';
import { ManagerPageComponent } from './manager-page/manager-page.component';
import { SidebarManagerComponent } from './sidebar-manager/sidebar-manager.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    FooterComponent,
    NewsfeedComponent,
    SidebarComponent,
    NavbarComponent,
    AccountDropdownComponent,
    TopNewsComponent,
    UserNewsComponent,
    SidebarProfileComponent,
    SidebarUserNewsComponent,
    ProfilePageComponent,
    ManagerPageComponent,
    SidebarManagerComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
