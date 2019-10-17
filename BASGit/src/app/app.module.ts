import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { FooterComponent } from './static-layout/footer/footer.component';
import { SidebarComponent } from './top-news-page/sidebar/sidebar.component';
import { NavbarComponent } from './static-layout/navbar/navbar.component';
import { AccountDropdownComponent } from './static-layout/account-dropdown/account-dropdown.component';
import { TopNewsComponent } from './top-news-page/top-news/top-news.component';
import { AppRoutingModule } from './app-routing.module';
import { UserStoriesComponent } from './user-stories-page/user-stories/user-stories.component';
import { SidebarProfileComponent } from './profile-page/sidebar-profile/sidebar-profile.component';
import { SidebarUserNewsComponent } from './user-stories-page/sidebar-user-news/sidebar-user-news.component';
import { UserProfileComponent } from './profile-page/user-profile/user-profile.component';
import { ManagerComponent } from './manager-page/manager/manager.component';
import { SidebarManagerComponent } from './manager-page/sidebar-manager/sidebar-manager.component';
import { SubmitStoryComponent } from './user-stories-page/submit-story/submit-story.component';
import { ViewAllUsersComponent } from './manager-page/view-all-users/view-all-users.component';
import { SubmittedUserStoriesComponent } from './manager-page/submitted-user-stories/submitted-user-stories.component';
import { UserAllStoriesComponent } from './profile-page/user-all-stories/user-all-stories.component';
import { UpdateProfileComponent } from './profile-page/update-profile/update-profile.component';
import { ManagerUserAllStoriesComponent } from './manager-page/manager-user-all-stories/manager-user-all-stories.component';
import { FeaturedUserStoriesComponent } from './user-stories-page/featured-user-stories/featured-user-stories.component';
import { SingleUserAllStoriesComponent } from './manager-page/single-user-all-stories/single-user-all-stories.component';
import { LoginPanelComponent } from './login-panel/login-panel.component';
import { CnnComponent } from './top-news-page/cnn/cnn.component';
import { FoxComponent } from './top-news-page/fox/fox.component';
import { NbcComponent } from './top-news-page/nbc/nbc.component';
import { SportsComponent } from './top-news-page/sports/sports.component';
import { PoliticsComponent } from './top-news-page/politics/politics.component';
import { BusinessComponent } from './top-news-page/business/business.component';
import { EntertainmentComponent } from './top-news-page/entertainment/entertainment.component';
import { TechnologyComponent } from './top-news-page/technology/technology.component';
import { SignUpPageComponent } from './sign-up-page/sign-up-page.component';
import { LogInPageComponent } from './log-in-page/log-in-page.component';

@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    SidebarComponent,
    NavbarComponent,
    AccountDropdownComponent,
    TopNewsComponent,
    SidebarProfileComponent,
    SidebarUserNewsComponent,
    UserProfileComponent,
    ManagerComponent,
    SidebarManagerComponent,
    UserStoriesComponent,
    SubmitStoryComponent,
    ViewAllUsersComponent,
    SubmittedUserStoriesComponent,
    UserAllStoriesComponent,
    UpdateProfileComponent,
    ManagerUserAllStoriesComponent,
    ManagerComponent,
    FeaturedUserStoriesComponent,
    SingleUserAllStoriesComponent,
    LoginPanelComponent,
    CnnComponent,
    FoxComponent,
    NbcComponent,
    SportsComponent,
    PoliticsComponent,
    BusinessComponent,
    EntertainmentComponent,
    TechnologyComponent,
    SignUpPageComponent,
    LogInPageComponent,
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
