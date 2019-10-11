import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes} from '@angular/router';
import { TopNewsComponent } from './top-news-page/top-news/top-news.component';
import { UserStoriesComponent } from './user-stories-page/user-stories/user-stories.component';
import { UserProfileComponent } from './profile-page/user-profile/user-profile.component';
import { ManagerComponent } from './manager-page/manager/manager.component';

const routes: Routes = [
  { path: '', redirectTo: '/topnews', pathMatch: 'full'},
  { path: 'topnews', component: TopNewsComponent },
  { path: 'userstories', component: UserStoriesComponent},
  { path: 'managerpage', component: ManagerComponent},
  { path: 'profilepage', component: UserProfileComponent},
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
