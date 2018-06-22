import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class NoteService {

  private headers = new Headers({ 'Content-Type': 'application/json' });
  private options = new RequestOptions({ headers: this.headers });
  constructor(private _http: Http) { }

  getNotes() {
    return this._http.get('http://localhost:8080/notes', this.options)
                     .map((response: Response) => response.json())
                     .catch(this.errorHandler);
  }

  errorHandler(error: Response) {
    return Observable.throw(error || "server cha 'NOTE SERVICE error");
  }
}
