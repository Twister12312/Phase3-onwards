import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../user';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private userService: UserServiceService, private route: Router) { }
  isclicked:boolean=false;
mail:string="";
passwd:string="";
user:any;
entered:boolean=false;
users:any=[];
  ngOnInit(): void {
    this.listTodos();
  
  }

  listTodos(){
    this.userService.getUsers().subscribe(
      (response: any)=>{this.users = response;
      console.log(this.users);},
    ((error: any)=>{console.error("Some problem in geeting data");})
    );
  }

  login(mail:any,pass:any){
    this.userService.loginUser(mail,pass).subscribe(
      (response:any)=>{
        this.user=response;
        //console.log(this.user);
        this.entered=true;
        

      }
,
      (error: any) => {
       
        
      }

      )
  }

email:any="";
  public validate_user(form:any){
    this.mail=form.email;
    this.passwd=form.passwd;
   this.login(this.mail,this.passwd);
   this.isclicked=true;
      if(this.entered==true){
        //console.log(this.user);
        this.email=(this.user).mail;
        //this.route.navigate([`/userhome/${this.email}`],this.email);}
        //this.route.navigate([`/register`]);
        this.redirect(this.email);
      }
     
      }

      public redirect(email:any){
        email=this.email;
        this.route.navigate(['/userhome',JSON.stringify(email)],email);
      }

      registerUser(){
        this.route.navigate(['/register']);
      }

      LoginAdmin(){
        this.route.navigate(['/admlogin']);
      }
  }



