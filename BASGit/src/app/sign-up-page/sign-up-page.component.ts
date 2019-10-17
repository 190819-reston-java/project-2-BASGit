import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms'

@Component({
  selector: 'app-sign-up-page',
  templateUrl: './sign-up-page.component.html',
  styleUrls: ['./sign-up-page.component.css']
})
export class SignUpPageComponent implements OnInit {



  constructor(private http: HttpClient) {}

   onSubmit(f: NgForm) {
    this.http.post("http://ec2-52-90-209-187.compute-1.amazonaws.com:5555/BASGit/test/formSubmission", JSON.stringify(f.value)).subscribe(res=>{
                 //here you received the response of your post
                 console.log(res);
                 //you can do asomething, like
           })
    console.log(f.value);  // { first: '', last: '' }
    console.log(JSON.stringify(f.value));
    console.log(f.valid);  // false
  }

  

        

  ngOnInit() {
  }

}
