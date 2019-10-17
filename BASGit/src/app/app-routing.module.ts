import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes} from '@angular/router';
import { TopNewsComponent } from './top-news-page/top-news/top-news.component';
import { UserStoriesComponent } from './user-stories-page/user-stories/user-stories.component';
import { UserProfileComponent } from './profile-page/user-profile/user-profile.component';
import { ManagerComponent } from './manager-page/manager/manager.component';
import { FeaturedUserStoriesComponent } from './user-stories-page/featured-user-stories/featured-user-stories.component';
import { SubmittedUserStoriesComponent } from './manager-page/submitted-user-stories/submitted-user-stories.component';
import { ManagerUserAllStoriesComponent } from './manager-page/manager-user-all-stories/manager-user-all-stories.component';
import { ViewAllUsersComponent } from './manager-page/view-all-users/view-all-users.component';
import { SingleUserAllStoriesComponent } from './manager-page/single-user-all-stories/single-user-all-stories.component';
import { UpdateProfileComponent } from './profile-page/update-profile/update-profile.component';
import { UserAllStoriesComponent } from './profile-page/user-all-stories/user-all-stories.component';
import { SubmitStoryComponent } from './user-stories-page/submit-story/submit-story.component';
import { SportsComponent } from './top-news-page/sports/sports.component';
import { BusinessComponent } from './top-news-page/business/business.component';
import { EntertainmentComponent } from './top-news-page/entertainment/entertainment.component';
import { PoliticsComponent } from './top-news-page/politics/politics.component';
import { TechnologyComponent } from './top-news-page/technology/technology.component';
import { CnnComponent } from './top-news-page/cnn/cnn.component';
import { NbcComponent } from './top-news-page/nbc/nbc.component';
import { FoxComponent } from './top-news-page/fox/fox.component';
import { SignUpPageComponent } from './sign-up-page/sign-up-page.component';
import { LogInPageComponent } from './log-in-page/log-in-page.component';

const routes: Routes = [
  { path: '', redirectTo: '/topnews/topnews', pathMatch: 'full'},
  { path: 'topnews/topnews', component: TopNewsComponent },
  { path: 'userstories/alluserstories', component: UserStoriesComponent},
  { path: 'manager/managerpage', component: ManagerComponent},
  { path: 'profile/profilepage', component: UserProfileComponent},
  { path: 'profile/userstories/submituserstories', component: SubmitStoryComponent },
  { path: 'userstories/topuserstories', component: FeaturedUserStoriesComponent},
  { path: 'manager/submitteduserstories', component: SubmittedUserStoriesComponent},
  { path: 'manager/manageralluserstories', component: ManagerUserAllStoriesComponent},
  { path: 'manager/viewallusers', component: ViewAllUsersComponent},
  { path: 'manager/singleuserallstories', component: SingleUserAllStoriesComponent},
  { path: 'profile/updateprofile', component: UpdateProfileComponent},
  { path: 'profile/userallstories', component: UserAllStoriesComponent},
  { path: 'topnews/sports', component: SportsComponent},
  { path: 'topnews/business', component: BusinessComponent},
  { path: 'topnews/entertainment', component: EntertainmentComponent},
  { path: 'topnews/politics', component: PoliticsComponent},
  { path: 'vtopnews/sports', component: SportsComponent},
  { path: 'topnews/technology', component: TechnologyComponent},
  { path: 'topnews/cnn', component: CnnComponent},
  { path: 'topnews/nbc', component: NbcComponent},
  { path: 'topnews/fox', component: FoxComponent},
  { path: 'signup/signup', component: SignUpPageComponent},
  { path: 'login/login', component: LogInPageComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
