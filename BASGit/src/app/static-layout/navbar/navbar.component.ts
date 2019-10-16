import { Component, OnInit } from '@angular/core';
import { AccountDropdownComponent } from '../account-dropdown/account-dropdown.component';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms'

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private http: HttpClient) { }

  //HEY, MAKE SURE TO CHECK THIS ENDPOINT

  onSubmit(f: NgForm) {
    this.http.get("http://ec2-52-90-209-187.compute-1.amazonaws.com:5555/BASGit/users/logout").subscribe(res=>{
                 //here you received the response of your post
                 console.log(res);
                 //you can do asomething, like
           })
  }

  ngOnInit() {
  }

}
