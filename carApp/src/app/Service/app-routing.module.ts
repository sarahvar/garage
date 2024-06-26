import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CarComponent } from '../Car/car.component';
import { CarEditComponent } from '../Car-edit/car-edit.component';
import { CarCreateComponent } from '../Car-create/car-create.component';
import { LoginComponent } from '../Login/login.component';

const routes: Routes = [
  //{ path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'cars', component: CarComponent },
  { path: 'cars/:id/edit', component: CarEditComponent },
  { path: 'cars/:id/delete', component: CarComponent },
  { path: 'cars/createCar', component: CarCreateComponent },
  { path: 'login', component: LoginComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
