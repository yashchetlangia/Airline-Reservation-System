import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/Service/user.service';
import { User } from '../User';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {
  email:String = '';
  password:String = '';
  userFound:boolean=false;
  user:User=new User();
  bol:boolean = false;
  constructor(private userService: UserService, private router:Router) 
 { }

  ngOnInit(): void {
   
  }

  async loginUser()  {  
    if(this.email!=null && this.password!=null){
     this.bol = false;       
    }

  
     await this.userService.loginUser(this.email,this.password).subscribe((data:any)=>{
       this.user = data;
       if(this.user.email == this.email && this.user.password == this.password){
         localStorage.setItem('userId',this.user.userId.toString());
         localStorage.setItem('userName',this.user.firstName.toString());
         console.log(localStorage.getItem('userId'));    
         this.router.navigateByUrl("userDash");
       }
       else{
         alert("Enter valid credentials")
       }

      },
      error => {
        console.log(error.status);
        if(error.status === 500){
         alert('Something went Wrong');
        }

    },)
      
   
   
}

 regUser()
 {
   this.router.navigateByUrl("userReg")
 }
}