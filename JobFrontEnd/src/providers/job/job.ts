import { ApiProvider } from './../api/api';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

/*
  Generated class for the JobProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class JobProvider {

  constructor(public api: ApiProvider,public  http: HttpClient) {
    console.log('Hello JobProvider Provider');
  }

  listarJob(){
    let requisicao = this.api.get("job");
    return requisicao;
  }

  deletarJob(body: any){
    let requisicao = this.api.post("job/deletar", body);
    return requisicao;
  }

}
