import { Component, OnInit, Input } from '@angular/core';
import { AuthenticateService } from '../_services/authenticate.service';
import { Router } from '@angular/router';
import { User } from '../_models/user';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {

  //@Input() user: User;

  constructor(private authService: AuthenticateService, private router: Router) { }

  ngOnInit(): void { }

  /************************************************************************
   * Method:        logout
   * params:
   * return:
   * Description:   This method is helping to logout from the userpage 
   *                component.
   ************************************************************************/
  logout() {
    this.authService.logout();
    this.router.navigateByUrl('/home');
  }

}
