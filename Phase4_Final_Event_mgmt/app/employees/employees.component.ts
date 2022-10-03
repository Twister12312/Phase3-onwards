import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CrudHttpService } from '../crud-http.service';
@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.css']
})
export class EmployeesComponent implements OnInit {
  createnew:boolean=false;
  employees:any = [];
  constructor(private crudHttpService: CrudHttpService, private route: Router) { }
  employee:any;
  ngOnInit(): void {
    this.listTodos();
  }

  listTodos(){
    this.crudHttpService.list().subscribe(
      (response: any)=>{this.employees = response;},
    ((error: any)=>{console.error("Some problem in geeting data");})
    );
  }
  redirect(id:any){
    this.route.navigate([`/employee/${id}`],id);
  }
  onSubmit(form:any){
    this.createnew=false;
    let data={
      id:form.idty,
      first_name:form.firstName,
      last_name:form.LastName,
      email:form.email
    }
    this.crudHttpService.create(data).subscribe((response: any)=>{
      this.listTodos();
    },((error: any)=>{
  
    }));
  }

  logout(){
    
  }
}
