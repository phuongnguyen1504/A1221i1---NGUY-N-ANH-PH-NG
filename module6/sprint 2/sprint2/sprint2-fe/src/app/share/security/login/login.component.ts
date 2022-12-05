import {Component, ElementRef, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {TokenStorageService} from "../../../service/token-storage.service";
import {Router} from "@angular/router";
import {ShareService} from "../../../service/share.service";
import {UserService} from "../../../service/user.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  formLogin:FormGroup;
  roles: string[] =[];
  constructor(private formBuilder: FormBuilder, private  el:ElementRef,
              private tokenStorageService: TokenStorageService,
              private router: Router,
              private userService: UserService,
              private shareService: ShareService) { }

  ngOnInit(): void {
    this.formLogin=this.formBuilder.group({
      username: ['', [Validators.required, Validators.pattern('^[a-zA-Z0-9]*$')]],
      password: ['', Validators.required],
      rememberMe: []
    })
  }

}
