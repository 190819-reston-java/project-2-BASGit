import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms'

@Component({
  selector: 'app-single-user-all-stories',
  templateUrl: './single-user-all-stories.component.html',
  styleUrls: ['./single-user-all-stories.component.css']
})
export class SingleUserAllStoriesComponent implements OnInit {

  users: any;
  stories: any;
  hasBeenClicked: boolean = false;

  constructor(private http : HttpClient) { }

  getStories(id) {
    let observable = this.http.get("http://ec2-52-90-209-187.compute-1.amazonaws.com:5555/BASGit/stories/users/"+id)
    observable.subscribe((result => {
      this.stories = result;
    }))
  }

  ngOnInit() {
    let observable = this.http.get('http://ec2-52-90-209-187.compute-1.amazonaws.com:5555/BASGit/users')
    observable.subscribe((result => {
      this.users = result;
    }))
  }
}
