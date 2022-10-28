import { Component, OnInit } from '@angular/core';
import { AuthenticateService } from '../_services/authenticate.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router: Router, private authService: AuthenticateService) { }
  ngOnInit(): void {
  }
  
  /***************************************************************************
   * Method:        OpenLoginView
   * params:
   * return:
   * Description:   This method is checking if the user has already logged in
   *                or not. If yes, the user will be directly transist to the 
   *                userpage. If not, the user will be asked to login again.  
   *              
   * Created Date:  21 JAN 2021
   * Author:        Princy Pandey
   ****************************************************************************/
  OpenLoginView()
  {
    //this.router.navigateByUrl('/login');
    if(this.authService.isLoggedIn()==true)
      {
        this.router.navigateByUrl('/userpage');
      }
    else
    {
      this.router.navigateByUrl('/login');
    }
  }
}
