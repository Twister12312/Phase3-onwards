import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public users:User[]=[]
  public ID:number=0;
  constructor(private userService: UserServiceService, private route: Router) { }

  ngOnInit(): void {
    this.getUsers();
  }

  public getUsers():void{
    this.userService.getUsers().subscribe(
      (response: User[]) => {
        this.users = response;
        console.log(this.users);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public registerUser(form:any){
    let data={
      uid:this.ID,
      name:form.firstName+" "+form.lastName,
      gender:form.gender,
      mail:form.email,
      passwd:form.passwd,
      dob:form.dob,
      address:form.address,
      pincode:Number(form.pincode)
    }
    this.userService.registerUser(data).subscribe(
     (response:any)=>{
     
     }
,
     (error: HttpErrorResponse) => {
      alert(error.message);
    }
    )

    this.route.navigate([`/login`]);
  }



}
