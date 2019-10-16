import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-user-stories',
  templateUrl: './user-stories.component.html',
  styleUrls: ['./user-stories.component.css']
})
export class UserStoriesComponent implements OnInit {

  userNews: any;

  constructor(private http : HttpClient) { }

  ngOnInit() {
    let observable = this.http.get('/BASGIT/stories')
    observable.subscribe((result => {
      this.userNews = result;
    }))
  }

}
