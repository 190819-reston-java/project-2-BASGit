import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms'

@Component({
  selector: 'app-single-user-all-stories',
  templateUrl: './single-user-all-stories.component.html',
  styleUrls: ['./single-user-all-stories.component.css']
})
export class SingleUserAllStoriesComponent implements OnInit {

  stories: any;

  constructor(private http : HttpClient) { }

  ngOnInit() {
    let observable = this.http.get('http://ec2-52-90-209-187.compute-1.amazonaws.com:5555/BASGit/stories/byUser')
    observable.subscribe((result => {
      this.stories = result;
    }))
  }
}
