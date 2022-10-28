import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddPolicyComponent } from './add-policy/add-policy.component';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ProductComponent } from './product/product.component';
import { SearchPolicyComponent } from './search-policy/search-policy.component';
import { UserPageComponent } from './user-page/user-page.component';
import { AuthGuardService } from './_services/auth-guard.service';


const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: 'home', component: HomeComponent},
  { path: 'login', component: LoginComponent },
  { path: 'adminpage', component: AdminPageComponent, canActivate: [AuthGuardService] },
  { path: 'userpage', component: UserPageComponent, canActivate: [AuthGuardService] },
  { path: 'addpolicy', component: AddPolicyComponent},
  { path: 'searchpolicy', component: SearchPolicyComponent},
  { path: 'product', component: ProductComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
