import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-top-news',
  templateUrl: './top-news.component.html',
  styleUrls: ['./top-news.component.css']
})
export class TopNewsComponent implements OnInit {

  topNews: any;
​
  constructor(private http : HttpClient) { }
​
  ngOnInit() {
    let observable = this.http.get('https://newsapi.org/v2/top-headlines?country=us&apiKey=596a0fc3564340dda0564acc17baae85')
    observable.subscribe((result=>{
      this.topNews = result;
    }))
  }
}



