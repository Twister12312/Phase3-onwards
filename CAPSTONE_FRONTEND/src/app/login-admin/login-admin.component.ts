import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-admin',
  templateUrl: './login-admin.component.html',
  styleUrls: ['./login-admin.component.css']
})
export class LoginAdminComponent implements OnInit {

  constructor( private route: Router) { }

  ngOnInit(): void {
  }
  iscorrect:boolean=true;
ID:any="Admin";
password:any="Admin@123!"

onSubmit(form:any){
  var id=form.UserId;
  var pass=form.passwd;
  if(id==this.ID&&pass==this.password){
    this.route.navigate(['/admhome']);
  }

  else{
    this.iscorrect=false;
  }
}

LoginUser(){
  this.route.navigate(['/login']);
}

registerUser(){
  this.route.navigate(['/register']);
}

}
