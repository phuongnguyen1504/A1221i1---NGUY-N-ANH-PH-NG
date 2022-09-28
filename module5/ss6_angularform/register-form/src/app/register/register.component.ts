import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {passValidator} from "../validator";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
//Tai lieu tham khao
// https://www.youtube.com/watch?v=QYwSI1ULjOM
// https://www.youtube.com/watch?v=Gt9odQS9w80&t=797s
export class RegisterComponent implements OnInit {
  rfRegister: FormGroup;
  country=['Anh','Mỹ','Hàn Quốc'];
  constructor(private _formBuilder:FormBuilder) {
    this.rfRegister=this._formBuilder.group({
      email:['',[Validators.required,Validators.email]],
      password:['',[Validators.required,Validators.minLength(6)]],
      confirm_password:['',[Validators.required,passValidator]],
      country:['',Validators.required],
      age:['',[Validators.required,Validators.min(18)]],
      gender:['',Validators.required],
      phone:['',[Validators.required,Validators.pattern(/^\+84\d{9,10}$/)]]
    });
    this.rfRegister.controls['password'].valueChanges
      .subscribe(
        x => this.rfRegister.controls['confirm_password'].updateValueAndValidity()
      )
  }

  ngOnInit(): void {

  }


  onSubmit() {
    console.log(this.rfRegister.value);
  }
}
