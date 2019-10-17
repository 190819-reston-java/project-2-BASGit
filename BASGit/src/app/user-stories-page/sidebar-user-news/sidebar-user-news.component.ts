import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms'

@Component({
  selector: 'app-sidebar-user-news',
  templateUrl: './sidebar-user-news.component.html',
  styleUrls: ['./sidebar-user-news.component.css']
})
export class SidebarUserNewsComponent implements OnInit {

  loggedInUser: any = null;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    let observable = this.http.get('http://ec2-52-90-209-187.compute-1.amazonaws.com:5555/BASGit/users/current')
    observable.subscribe((result => {
      this.loggedInUser = result;
    }))
  }

}
