import { JobProvider } from './../../providers/job/job';
import { ServicoProvider } from './../../providers/servico/servico';
import { Component } from '@angular/core';
import { NavController, AlertController } from 'ionic-angular';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  public ListJobs = null;
  constructor(
    public navCtrl: NavController,
    public jobProvider:JobProvider,
    public alertController: AlertController) {

      this.carregarJobs();

  }

  carregarJobs(){
    this.jobProvider.listarJob().subscribe(
      data => {
          this.ListJobs = data;
      }, error => {
        this.presentAlert();
        console.log(error);
      });
  }

  deletarJob(job: any){
    this.jobProvider.deletarJob(job).subscribe(
      data => {
        this.carregarJobs();
        console.log(data);
      },
      error =>{
        this.carregarJobs();
        this.presentAlert();
        console.log(error);
      });
  }

  async presentAlert() {
    const alert = await this.alertController.create({
      message: 'Desculpe, Api esta fora de alcance',
      buttons: ['OK']
    });

    await alert.present();
  }

}
