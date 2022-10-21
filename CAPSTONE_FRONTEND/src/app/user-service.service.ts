import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) { }
  public getUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.apiServerUrl}/User/all`);
  }

  public registerUser(user: any): Observable<any> {
    return this.http.post<any>(`${this.apiServerUrl}/User/register`, user);
  }

  public updateUser(user: User): Observable<User> {
    return this.http.put<User>(`${this.apiServerUrl}/User/update`, user);
  }

  public deleteUser(UserId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/User/delete/${UserId}`);
  }

  public loginUser(email:string,passwd:string):Observable<any>{
    return this.http.get<any>(`${this.apiServerUrl}/User/login/${email}/${passwd}`);
  }

  public FindbyMail(email:string):Observable<any>{
    return this.http.get<any>(`${this.apiServerUrl}/User/find/${email}`);
  }


  public EnterLog(email:any,data:any):Observable<any>{

    return this.http.put<any>(`${this.apiServerUrl}/User/enterlog/${email}`,data);
  }

  public Getlog():Observable<any>{
    return this.http.get<any>(`${this.apiServerUrl}/Admin/log`);
  }

  public updateStatus(logid:any,status:any):Observable<any>{
    return this.http.post<any>(`${this.apiServerUrl}/Admin/update/${logid}/${status}`,logid);
  }

}
