import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CarComponent } from '../Car/car.component';
import { CarEditComponent } from '../Car-edit/car-edit.component';
import { FormsModule } from '@angular/forms';
import { CarCreateComponent } from '../Car-create/car-create.component';
import { CustomInterceptor } from './customInterceptor';
import { LoginComponent } from '../Login/login.component';

const appRoutes: Routes = [
  { path: 'cars', component: CarComponent },
  { path: 'cars/:id/edit', component: CarEditComponent },
  // Add more routes here if needed
];

@NgModule({
  declarations: [
    AppComponent,
    CarComponent,
    CarEditComponent,
    CarCreateComponent,
    LoginComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    FormsModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: CustomInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule {

}
