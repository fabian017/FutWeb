import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './pages/home/home.component';
import { HistoryComponent } from './pages/history/history.component';
import { PlayersComponent } from './pages/players/players.component';
import { StatisticsComponent } from './pages/statistics/statistics.component';
import { TicketsOfficeComponent } from './pages/tickets-office/tickets-office.component';
import { StoreComponent } from './pages/store/store.component';
import { TeamRoutingModule } from './team-routing.module';
import { FlexLayoutModule } from '@angular/flex-layout';
import { MaterialModule } from '../material/material.module';
import { InicioComponent } from './pages/inicio/inicio.component';



@NgModule({
  declarations: [
    HomeComponent,
    HistoryComponent,
    PlayersComponent,
    StatisticsComponent,
    TicketsOfficeComponent,
    StoreComponent,
    InicioComponent,

  ],
  imports: [
    CommonModule,
    TeamRoutingModule,
    FlexLayoutModule,
    MaterialModule,
  ]
})
export class TeamModule { }
