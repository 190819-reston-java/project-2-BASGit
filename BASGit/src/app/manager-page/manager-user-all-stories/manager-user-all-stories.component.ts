import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms'
import { Router } from '@angular/router';

@Component({
  selector: 'app-manager-user-all-stories',
  templateUrl: './manager-user-all-stories.component.html',
  styleUrls: ['./manager-user-all-stories.component.css']
})
export class ManagerUserAllStoriesComponent implements OnInit {

  stories: any;

  constructor(private http: HttpClient,
    private router: Router) { }

highlightStory(id) {
  this.http.post("http://ec2-52-90-209-187.compute-1.amazonaws.com:5555/BASGit/stories/admin/handle", `${id} h`).subscribe(res=>{
    //here you received the response of your post
    console.log(res);
    //you can do asomething, like
})
console.log(`${id} h`);
this.router.navigateByUrl("/userstories/topuserstories");
}

removeStory(id) {
  this.http.post("http://ec2-52-90-209-187.compute-1.amazonaws.com:5555/BASGit/stories/admin/handle", `${id} r`).subscribe(res=>{
    //here you received the response of your post
    console.log(res);
    //you can do asomething, like
})
console.log(`${id} r`);
this.router.navigateByUrl("/userstories/userstories");
}


ngOnInit() {
    let observable = this.http.get('http://ec2-52-90-209-187.compute-1.amazonaws.com:5555/BASGit/stories')
    observable.subscribe((result => {
      this.stories = result;
    }))
  }
}
