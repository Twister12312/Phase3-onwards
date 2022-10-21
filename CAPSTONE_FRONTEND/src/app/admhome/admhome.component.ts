import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserServiceService } from '../user-service.service';

@Component({
  selector: 'app-admhome',
  templateUrl: './admhome.component.html',
  styleUrls: ['./admhome.component.css']
})
export class AdmhomeComponent implements OnInit {
  log:any=[];
  users:any=[]
  status:boolean=true;
  constructor(private userService: UserServiceService, private route: Router) { }

  ngOnInit(): void {
    this.getlog();
    this.getUsers();
  }

  getlog(){
    this.userService.Getlog().subscribe(
      (response: any)=>{this.log = response;
        console.log(this.log);},
      ((error: any)=>{console.error("Some problem in geeting data");})

    )
  }

  getUsers(){
    this.userService.getUsers().subscribe(
      (response: any)=>{this.users= response;
        console.log(this.log);},
      ((error: any)=>{console.error("Some problem in geeting data");})
    )
  }

  Accept(id:any){
    this.userService.updateStatus(id,this.status).subscribe(
      (response: any)=>{this.log = response;
        console.log(this.log);
      this.getlog();},
      ((error: any)=>{console.error("Some problem in geeting data");})

    )
  }

  delete(id:any){
this.userService.deleteUser(id).subscribe(
  (response: any)=>{
    console.log(this.log);
  this.getUsers();},
  ((error: any)=>{console.error("Some problem in geeting data");})
)
  }

  Logout(){
    this.route.navigate(['/admlogin']);
  }

}
