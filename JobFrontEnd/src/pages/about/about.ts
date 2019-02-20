import { TaskProvider } from './../../providers/task/task';
import { JobProvider } from './../../providers/job/job';
import { Component } from '@angular/core';
import { NavController, AlertController } from 'ionic-angular';

@Component({
  selector: 'page-about',
  templateUrl: 'about.html'
})
export class AboutPage {

  public job = {
    name:"",
    active:false,
    parentJob:[],
    tasks:[]
   }
  public listJobs = null;
  public listTasks= null;
  constructor(public navCtrl: NavController,
    public jobProvider:JobProvider,
    public alertController: AlertController,
    public taskPorvider:TaskProvider) {

      this.job
  }

  ngOnInit(){
  }



  criarJob(){
    let taskArray=[];
    this.job.tasks.forEach(taskId => {
      this.listTasks.forEach(task => {
        if(task.id == taskId){
          taskArray.push(task);
        }          
      });
    });

    this.listJobs.forEach(element => {
      if(element.id == this.job.parentJob){
        this.job.parentJob = [element];
      }  
    });
    this.job.tasks = taskArray;
    this.jobProvider.salvarJob(this.job).subscribe(
      data => {
        this.presentAlert("Registro salvo com sucesso");
      }, error =>{
        this.presentAlert("Falha ao salvar registro");

      });
  }
  carregarJobs(){
    this.jobProvider.listarJob().subscribe(
      data => {
          this.listJobs = data;
      }, error => {
        this.presentAlert("Falha ao listar Jobs");
        console.log(error);
      });
  }

  carregarTaslk(){
    this.taskPorvider.listarTasks().subscribe(
      data => {
          this.listTasks = data;
          this.filtroTasks(this.listTasks);
      }, error => {
        this.presentAlert("Falha ao listar tasks");
        console.log(error);
      });
  }

  async presentAlert(mensagem:string) {
    const alert = await this.alertController.create({
      message: mensagem,
      buttons: ['OK']
    });

    await alert.present();
  }

  filtroTasks(tasks){
      for (let index = 0; index < tasks.length; index++) {
        if (tasks[index].job == null) {
            tasks.splice(index,1);
        }
      }
  } 

}
