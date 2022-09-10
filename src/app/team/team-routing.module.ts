import { NgModule } from '@angular/core';
import { Router, RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { HistoryComponent } from './pages/history/history.component';
import { PlayersComponent } from './pages/players/players.component';
import { StatisticsComponent } from './pages/statistics/statistics.component';
import { TicketsOfficeComponent } from './pages/tickets-office/tickets-office.component';
import { StoreComponent } from './pages/store/store.component';
import { InicioComponent } from './pages/inicio/inicio.component';

const routes : Routes = [
  {
    path:'',
    component:HomeComponent,
    children:[
      {
        path:'inicio',
        component:InicioComponent
      },
      {
        path:'history',
        component:HistoryComponent
      },
      {
        path:'players',
        component:PlayersComponent
      },
      {
        path:'statistics',
        component:StatisticsComponent
      },
      {
        path:'tickets',
        component:TicketsOfficeComponent
      },
      {
        path:'store',
        component:StoreComponent
      },
      {
        path:'**',
        redirectTo: 'inicio'
      }
    ]
  }
]

@NgModule({

  imports: [
    RouterModule.forChild(routes)
  ],
  exports:[
    RouterModule
  ]
})
export class TeamRoutingModule { }
