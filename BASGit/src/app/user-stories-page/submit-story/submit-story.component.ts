import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms'
import { Router } from '@angular/router';

@Component({
  selector: 'app-submit-story',
  templateUrl: './submit-story.component.html',
  styleUrls: ['./submit-story.component.css']
})
export class SubmitStoryComponent implements OnInit {

  constructor(private http: HttpClient,
    private router: Router) { }

  onSubmit(f: NgForm) {
    this.http.post("http://ec2-52-90-209-187.compute-1.amazonaws.com:5555/BASGit/test/storySubmission", JSON.stringify(f.value)).subscribe(res=>{
                 //here you received the response of your post
                 console.log(res);
                 //you can do asomething, like
           })
    console.log(f.value);  // { first: '', last: '' }
    console.log(JSON.stringify(f.value));
    console.log(f.valid);  // false
    this.router.navigateByUrl("/userstories/alluserstories");
  }

  ngOnInit() {
  }

}
