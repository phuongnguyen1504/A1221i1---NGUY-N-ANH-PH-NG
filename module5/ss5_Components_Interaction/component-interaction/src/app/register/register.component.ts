import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  rfRegister:FormGroup;
  constructor(private _formBuilder:FormBuilder) { }

  ngOnInit(): void {
    this.rfRegister=this._formBuilder.group({
      email:['',[Validators.required,Validators.pattern()]],
      password:['',[Validators.required,Validators.minLength(6)]],
      confirm_password:['',[Validators.required,Validators.minLength(6),]],
      country:['',Validators.required],
      age:['',Validators.min(18)],
      gender:[],
    },{Validators:this.mustMatch('password','confirm_password')})
  }
  mustMatch(password:any,confirmpassword:any){
    return (formGroup:FormGroup)=>{
      const psw=formGroup.controls[password];
      const cfpsw=formGroup.controls[confirmpassword];
      if(cfpsw.errors && !cfpsw.errors['mustMatch']){
        return;
      }
      if (psw.value!=cfpsw.value){

      }
    }
  }

  onSubmit() {
    console.log(this.rfRegister.value);
  }
}
