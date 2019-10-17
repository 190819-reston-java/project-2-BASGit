import { Component, OnInit } from '@angular/core';
import { AccountDropdownComponent } from '../account-dropdown/account-dropdown.component';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms'
import { Router, ActivatedRoute, Event, NavigationStart } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  loggedInUser: any = null;

  constructor(private http: HttpClient,
    private router: Router) { }

  onSubmit(f: NgForm) {
    this.http.get("http://ec2-52-90-209-187.compute-1.amazonaws.com:5555/BASGit/users/signout").subscribe(res=>{
                 //here you received the response of your post
                 console.log(res);
                 //you can do asomething, like
           })
           window.location.href = 'http://ec2-52-90-209-187.compute-1.amazonaws.com:5555/BASGit/static/BASGit/';
  }

    ngOnInit() {
    let observable = this.http.get('http://ec2-52-90-209-187.compute-1.amazonaws.com:5555/BASGit/users/current')
    observable.subscribe((result => {
      this.loggedInUser = result;
    }))
  }





}
