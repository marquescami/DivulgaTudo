import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTable, MatTableDataSource } from '@angular/material/table';
import Anuncio from 'src/app/shared/models/anuncios.model';
import { DashboardService } from '../dashboard.service';
import { AnunciosTableDataSource, AnunciosTableItem } from './anuncios-table-datasource';

@Component({
  selector: 'app-anuncios-table',
  templateUrl: './anuncios-table.component.html',
  styleUrls: ['./anuncios-table.component.css']
})
export class AnunciosTableComponent implements AfterViewInit, OnInit {
  @ViewChild(MatPaginator)
  paginator!: MatPaginator;
  @ViewChild(MatSort)
  sort: MatSort = new MatSort;
  @ViewChild(MatTable)
  table!: MatTable<Anuncio>;
  constructor(private dashboardService: DashboardService) { }

  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  ELEMENT_DATA: Anuncio[] = [];
  displayedColumns = ['id', 'cliente', 'nomeDoAnuncio', 'dataDeInicio', 'dataDeTermino', 'investimentoPorDia', 'valorTotalInvestido', 'quantidadeMaximaDeVisualizacoes', 'quantidadeMaximaDeCliques', 'quantidadeMaximaDeCompartilhamentos'];
  dataSource = new MatTableDataSource<Anuncio>(this.ELEMENT_DATA);
  ngOnInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
    this.fetchStocks();
  }

  async fetchStocks(): Promise<void>{
    this.dataSource.data = await this.dashboardService.getAnuncios();
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
    this.table.dataSource = this.dataSource;
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}
