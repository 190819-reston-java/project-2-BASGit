import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-top-news',
  templateUrl: './top-news.component.html',
  styleUrls: ['./top-news.component.css']
})
export class TopNewsComponent implements OnInit {

  pageName='TOP NEWS';

  topNews: any;
  newsSelection: String = "country=us";

  imageStatus(imageJson) {
    if(imageJson) {
      return true;
    } else {
      return false;
    }
  }

  //Detects if the source is Fox, CNN, or NBC
  sourceCheck(sourceJson){
    if(sourceJson === 'NBC News'||sourceJson === 'CNN'||sourceJson === 'Fox News'){
      return true;
    } else {
      return false;
    }
  }

  //Links to the Fox/CNN/NBC page
  sourceDirector(sourceJson){
    if(sourceJson === 'NBC News'){
      return "/topnews/nbc";
    } else if(sourceJson === 'CNN') {
      return "/topnews/cnn";
    } else {
      return "/topnews/fox";
    }
  }

  synopsisStatus(synopsisJson) {
    //this is for youtube stories that give a boilerplate synopsis that says nothing
    if(synopsisJson === "[[getSimpleString(data.title)]]\r\n[[getSimpleString(data.description)]]\r\n[[getSimpleString(data.videoCountText)]]") {
      return false;
    } else if(synopsisJson) {
      return true; 
    } else {
      return false;
    }
  }


  constructor(private http : HttpClient) { }
​
  ngOnInit() {
    let observable = this.http.get(`https://newsapi.org/v2/top-headlines?${this.newsSelection}&apiKey=596a0fc3564340dda0564acc17baae85`)
    observable.subscribe((result=>{
      this.topNews = result;
    }))
    
  }
}



