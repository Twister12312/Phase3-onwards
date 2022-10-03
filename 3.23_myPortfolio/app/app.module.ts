import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { HomepageComponent } from './homepage/homepage.component';
import { AboutUsComponent } from './homepage/about-us/about-us.component';
import { ContactusComponent } from './homepage/contactus/contactus.component';
import { SigninComponent } from './homepage/signin/signin.component';
import { SignupComponent } from './homepage/signup/signup.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    AboutUsComponent,
    ContactusComponent,
    SigninComponent,
    SignupComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path : 'signin', component : SigninComponent},
    {path : 'signup', component: SignupComponent},
    {path : 'homepage', component:  HomepageComponent}]),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
