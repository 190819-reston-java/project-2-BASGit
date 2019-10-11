import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes} from '@angular/router';
import { TopNewsComponent } from './top-news/top-news.component';
import { UserNewsComponent } from './user-news/user-news.component';
import { ProfilePageComponent } from './profile-page/profile-page.component';
import { ManagerPageComponent } from './manager-page/manager-page.component';

const routes: Routes = [
  { path: '', redirectTo: '/topnews', pathMatch: 'full'},
  { path: 'topnews', component: TopNewsComponent },
  { path: 'usernews', component: UserNewsComponent},
  { path: 'managerpage', component: ManagerPageComponent},
  { path: 'profilepage', component: ProfilePageComponent},
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
