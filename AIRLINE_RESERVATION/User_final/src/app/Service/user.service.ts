import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
 
  private baseUrl = "http://localhost:8090/api/v1";
  constructor(private http:HttpClient) { }

  getAllUsers()
  {
    return this.http.get<any[]>(this.baseUrl+"/users");
  }

  createUser(User: Object): Observable<Object> {
    console.log(this.http.post(`${this.baseUrl}`+'/addnewuser', User));
    
   // return this.http.post(`${this.baseUrl}`+'/addnewuser', User);
    return this.http.post("http://localhost:8090/api/v1//addnewuser", User)
   }

   loginUser(email:String, password:String)
   {
     
     console.log(this.http.get("http://localhost:8090/api/v1/users/"+email+"/"+password));
     return this.http.get("http://localhost:8090/api/v1/users/"+email+"/"+password);

     
   }
}

