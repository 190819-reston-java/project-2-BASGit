import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms'
import { Router } from '@angular/router';

@Component({
  selector: 'app-log-in-page',
  templateUrl: './log-in-page.component.html',
  styleUrls: ['./log-in-page.component.css']
})
export class LogInPageComponent implements OnInit {

  constructor(private http: HttpClient,
              private router: Router) { }

  ngOnInit() {
  }

  onSubmit(f: NgForm) {
    if(f.value.managerCode === "1908-REVATURE") {
      f.value.managerCode = true;
    } else {
      f.value.managerCode = false;
    }
        this.http.post("http://ec2-52-90-209-187.compute-1.amazonaws.com:5555/BASGit/users/login", JSON.stringify(f.value)).subscribe(res=>{
                     //here you received the response of your post
                     console.log(res);
                     //you can do asomething, like
               })
        console.log(f.value);  // { first: '', last: '' }
        console.log(f.valid);  // false
        window.location.href = 'http://ec2-52-90-209-187.compute-1.amazonaws.com:5555/BASGit/static/BASGit/';
      }
    

}
