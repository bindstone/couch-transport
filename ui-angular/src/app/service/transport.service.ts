import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable()
export class TransportService {

  constructor(private http: HttpClient) {
  }

  public getAll(): Observable<any> {
    return this.http.get("/api/v1/transport/")
  }

}
