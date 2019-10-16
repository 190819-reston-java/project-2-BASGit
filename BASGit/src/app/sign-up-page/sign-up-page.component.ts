import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-sign-up-page',
  templateUrl: './sign-up-page.component.html',
  styleUrls: ['./sign-up-page.component.css']
})
export class SignUpPageComponent implements OnInit {

  constructor(private http: HttpClient) { }
  
  submit(formGroup)
  {

        this.http.post("http://ec2-52-90-209-187.compute-1.amazonaws.com:5555/BASGit/users/signup", formGroup.value).subscribe(res=>{
                 //here you received the response of your post
                 console.log(res);
                 //you can do asomething, like
           })
  }

  ngOnInit() {
  }

}
