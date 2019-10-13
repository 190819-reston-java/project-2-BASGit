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

const routes: Routes = [
  { path: '', redirectTo: '/topnews', pathMatch: 'full'},
  { path: 'topnews', component: TopNewsComponent },
  { path: 'userstories', component: UserStoriesComponent},
  { path: 'managerpage', component: ManagerComponent},
  { path: 'profilepage', component: UserProfileComponent},
  { path: 'submituserstories', component: SubmitStoryComponent },
  { path: 'topuserstories', component: FeaturedUserStoriesComponent},
  { path: 'submitteduserstories', component: SubmittedUserStoriesComponent},
  { path: 'manageralluserstories', component: ManagerUserAllStoriesComponent},
  { path: 'viewallusers', component: ViewAllUsersComponent},
  { path: 'singleuserallstories', component: SingleUserAllStoriesComponent},
  { path: 'updateprofile', component: UpdateProfileComponent},
  { path: 'userallstories', component: UserAllStoriesComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
