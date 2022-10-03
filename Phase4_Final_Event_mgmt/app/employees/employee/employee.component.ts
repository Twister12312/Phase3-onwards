import { Component, Input, OnInit } from '@angular/core';
import { CrudHttpService } from 'src/app/crud-http.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  constructor(private crudHttpService: CrudHttpService, private route: ActivatedRoute, 
    private Route: Router) { }
    myParamValue: any;
  ngOnInit(): void {
    this.myParamValue = this.route.snapshot.paramMap.get('id');
    this.viewTodo(this.myParamValue);
  }
  isupdate:boolean=false;
  employee:any;

  viewTodo(id:any){
   
    this.crudHttpService.listbyId(id).subscribe((response: any)=>{
      this.employee=response;
      console.log(this.employee);
      return this.employee;
    },((error: any)=>{
      console.error("Some problem in geeting data");
    }));
  }

  Employees(){
    this.Route.navigate([`/employees`]);
  }

  onSubmit(form:any){
    this.isupdate=false;
    let data = {
      id: this.employee.id,
      first_name:form.firstName,
      last_name:form.LastName,
      email:form.email
    }
    this.crudHttpService.update(this.employee.id,data).subscribe((response: any)=>{
      this.viewTodo(this.employee.id);
    },((error: any)=>{
  
    }));
  }
delete(){
  this.crudHttpService.delete(this.employee.id).subscribe((response: any)=>{
    this.Route.navigate([`/employees`]);
  },((error: any)=>{
  }));
}
  wantUpdate(){
this.isupdate=true;
  }

}
