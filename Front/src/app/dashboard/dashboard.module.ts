import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AnunciosTableComponent } from './anuncios-table/anuncios-table.component';
import { MatTableModule } from '@angular/material/table';
import { HttpClientModule } from '@angular/common/http';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { AnunciosFormComponent } from './anuncios-form/anuncios-form.component';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { MatCardModule } from '@angular/material/card';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
  AnunciosTableComponent,
  AnunciosFormComponent],
  imports: [
    CommonModule,
    HttpClientModule,
    MatTableModule,
    MatInputModule,
    MatButtonModule,
    MatSelectModule,
    MatRadioModule,
    MatCardModule,
    ReactiveFormsModule,
  ],
  exports:[
    AnunciosTableComponent,
    AnunciosFormComponent
  ],
})
export class DashboardModule { }
