import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';

@Component({
  selector: 'page-about',
  templateUrl: 'about.html'
})
export class AboutPage {

  job = {
    name:"",
    active:false,
    parentJob:null,
    tasks:null
   }
   selecionado = true;
  constructor(public navCtrl: NavController) {

  }




}
