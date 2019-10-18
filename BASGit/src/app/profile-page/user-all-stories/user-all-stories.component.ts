import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-user-all-stories',
  templateUrl: './user-all-stories.component.html',
  styleUrls: ['./user-all-stories.component.css']
})
export class UserAllStoriesComponent implements OnInit {

  user: any;
  stories: any;
  userId: any;

  constructor(private http : HttpClient) { }

  ngOnInit() {
    this.http.get('http://ec2-52-90-209-187.compute-1.amazonaws.com:5555/BASGit/users/current').subscribe(result =>{
    this.user = result;
    this.http.get(`http://ec2-52-90-209-187.compute-1.amazonaws.com:5555/BASGit/stories/user/${this.user.id}`).subscribe(res => {
      this.stories = res;
    })
    })
  } 

}
