import {Injectable} from '@angular/core';
import {Observable} from "rxjs/internal/Observable";
import {of} from "rxjs/internal/observable/of";

@Injectable({
  providedIn: 'root'
})
export class DataService {

  // type: string = null;

  constructor() {
  }

  requestLoginForm(type: string): Observable<string> {
    if (type === 'login') {
      return of('login');
    }
    return of(null);
  }

  requestJoinForm(type: string): Observable<string> {
    if (type === 'join') {
      return of('join');
    }
    return of(null);
  }
}
