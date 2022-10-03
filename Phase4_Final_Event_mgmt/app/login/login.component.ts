import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private route: Router) { }
  iscorrect:boolean=true;
  onSubmit(form:any){
    var firstName = form.firstName;
    var lastName = form.lastName;
    if(firstName=="user1"&&lastName=="hello"){
    this.route.navigate(['/home']);
    }
    else{
      this.iscorrect=false;

    }
    
  }
  ngOnInit(): void {
  }

}
