
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import Anuncio from '../shared/models/anuncios.model';
import { catchError, map } from 'rxjs/operators';
import { EMPTY, Observable } from 'rxjs';
import AnuncioDTO from '../shared/models/anunciosDTO.model';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  readonly baseUrl = 'http://localhost:8080/gerenciamentodeanuncios';

  constructor(private http: HttpClient) { }

  async getAnuncios(): Promise<Anuncio[]>{
    return this.http.get<Anuncio[]>(this.baseUrl + '/anuncios').toPromise();
  }

  create(anuncio: AnuncioDTO): Observable<AnuncioDTO> {
    return this.http.post<AnuncioDTO>(this.baseUrl + '/anuncios', anuncio).pipe(
      map(obj => obj),
      catchError(e => this.errorHandler(e))
    )
  }

  errorHandler(e: any): Observable<any> {
    var err: string
    e.error.errors.forEach((element) => {
    });
    return EMPTY
  }

}
