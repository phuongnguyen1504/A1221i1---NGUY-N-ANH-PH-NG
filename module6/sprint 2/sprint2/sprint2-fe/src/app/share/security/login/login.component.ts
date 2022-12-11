import {Component, ElementRef, EventEmitter, OnInit, Output, ViewChild} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {TokenStorageService} from '../../../service/token-storage.service';
import {Router} from '@angular/router';
import {ShareService} from '../../../service/share.service';
import {UserService} from '../../../service/user.service';
import {AuthService} from '../../../service/auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  formLogin: FormGroup;
  roles: string[] = [];
  @ViewChild('closebutton') closebutton;

  constructor(private formBuilder: FormBuilder, private  el: ElementRef,
              private tokenStorageService: TokenStorageService,
              private router: Router,
              private authService: AuthService,
              private userService: UserService,
              private shareService: ShareService) { }

  ngOnInit(): void {
    this.formLogin = this.formBuilder.group({
      username: ['', [Validators.required, Validators.pattern('^[a-zA-Z0-9]*$')]],
      password: ['', Validators.required],
      rememberMe: []
    });
  }
  login(): void {
    if (this.formLogin.valid) {
      console.log(this.formLogin.value);
      this.authService.login(this.formLogin.value).subscribe(
        data => {
          this.tokenStorageService.saveTokenSession(data.accessToken);
          this.userService.getUserFromToken(data.accessToken).subscribe(value => {
              this.tokenStorageService.saveUserSession(value);
              this.authService.isLoggedIn = true;
              this.formLogin.reset();
              this.closebutton.nativeElement.click();
              this.shareService.sendClickEvent();
              this.router.navigateByUrl('');
            }
          );
        },
        err => {
          this.authService.isLoggedIn = false;
        }
      );
    }
  }

  get username() {
    return this.formLogin.get('username');
  }

  get password() {
    return this.formLogin.get('password');
  }

}