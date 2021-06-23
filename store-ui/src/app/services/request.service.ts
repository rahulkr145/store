import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RequestService {

  constructor(private http: HttpClient) {
  }

  get<T>(relativePath: string): Observable<T> {
    return this.http.get<T>(`${environment.baseUrl}/${relativePath}`, {});
  }

  post<T>(relativePath: string, body: any): Observable<T> {
    console.log('inside post', relativePath);
    return this.http.post<T>(`${environment.baseUrl}/${relativePath}`, body, {});
  }
}
