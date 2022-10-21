import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserServiceService } from 'src/app/user-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  myParamValue: any;
  constructor(private userService: UserServiceService, private route: Router,
    private Route: ActivatedRoute
    ) { }

user:any;
isnew:boolean=false;
isupdate:boolean=false;
isduplicate:boolean=false;
status:boolean=false;

  ngOnInit(): void {
    this.myParamValue = JSON.parse(this.Route.snapshot.params["email"]);
    
    this.viewUser(this.myParamValue);
   
  }

  viewUser(usr:any){
    this.userService.FindbyMail(usr).subscribe(
      (response:any)=>{
        this.user=response;
        console.log(this.user);
       
      }
,
      (error: any) => {
       
        alert(error.message);
        
      }

    )
  }




  public New(email:any){
this.isnew=true;
let data={
  newappln:this.isnew,
  update:this.isupdate,
  duplicate:this.isduplicate,
  status:this.status
}
this.userService.EnterLog(email,data).subscribe(
  (response: any)=>{
    console.log("Success");
    },
  ((error: any)=>{console.error("Some problem in geeting data");})

);
  }

  public update(email:any){
    this.isupdate=true;
    let data={
      new:this.isnew,
      update:this.isupdate,
      duplicate:this.isduplicate
    }
    this.userService.EnterLog(email,data).subscribe(
      (response: any)=>{
        console.log("Success");
        },
      ((error: any)=>{console.error("Some problem in geeting data");})
    
    );

  }

  public Duplicate(email:any){
     this.isduplicate=true;
     let data={
      new:this.isnew,
      update:this.isupdate,
      duplicate:this.isduplicate
    }
    this.userService.EnterLog(email,data).subscribe(
      (response: any)=>{
        console.log("Success");
        },
      ((error: any)=>{console.error("Some problem in geeting data");})
    
    );
  }

  public Logout(){
    this.route.navigate(['/login']);
  }

}
