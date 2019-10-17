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
  constructor(private http : HttpClient) { }

  getStories(id) {
    let storiesobservable = this.http.get(`http://ec2-52-90-209-187.compute-1.amazonaws.com:5555/BASGit/stories/user/${id}`)
    storiesobservable.subscribe((res => {
      this.stories = res;
    }))
    return this.stories;
  }

  ngOnInit() {
    let userobservable = this.http.get('http://ec2-52-90-209-187.compute-1.amazonaws.com:5555/BASGit/users')
    userobservable.subscribe((result => {
      this.users = result;
    }))
  }
}
