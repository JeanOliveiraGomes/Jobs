import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

/*
  Generated class for the ApiProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class ApiProvider {

  url: string = 'http://localhost:8080';

  constructor(public http: HttpClient) {
    console.log('Hello ApiProvider Provider');
  }

  get(endpoint: string) {
    return this.http.get(this.url + '/' + endpoint);
  }
  getSemCabecalho(endpoint: string) {
    return this.http.get(this.url + '/' + endpoint);
  }

  post(endpoint: string, body: any) {
    return this.http.post(this.url + '/' + endpoint, body);
  }

  put(endpoint: string, body: any) {
    return this.http.put(this.url + '/' + endpoint, body);
  }

  delete(endpoint: string, body: any) {
    return this.http.delete(this.url + '/' + endpoint, body);
  }

  patch(endpoint: string, body: any, reqOpts?: any) {
    return this.http.patch(this.url + '/' + endpoint, body, reqOpts);
  }


}
