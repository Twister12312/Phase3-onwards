import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { LoginAdminComponent } from './login-admin/login-admin.component';
import { RegisterComponent } from './register/register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { RegpromptComponent } from './regprompt/regprompt.component';
import { HomeComponent } from './login/home/home.component';
import { AdmhomeComponent } from './admhome/admhome.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LoginAdminComponent,
    RegisterComponent,
    RegpromptComponent,
    HomeComponent,
    AdmhomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path : 'login', component : LoginComponent},
      {path : 'register', component : RegisterComponent},
      {path : 'userhome/:email', component : HomeComponent},
      {path : 'admhome', component : AdmhomeComponent},
      {path : 'admlogin', component : LoginAdminComponent}
      
  ]),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
