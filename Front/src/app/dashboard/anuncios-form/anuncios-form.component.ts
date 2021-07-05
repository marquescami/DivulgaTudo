import { Component } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { DashboardService } from '../dashboard.service';

@Component({
  selector: 'app-anuncios-form',
  templateUrl: './anuncios-form.component.html',
  styleUrls: ['./anuncios-form.component.css']
})
export class AnunciosFormComponent {
  anuncioForm = this.fb.group({
    id: null,
    cliente: ['', Validators.required],
    nomeDoAnuncio: ['', Validators.required],
    dataDeInicio: ['', Validators.required],
    dataDeTermino: ['', Validators.required],
    investimentoPorDia: ['', Validators.required]
  });



  constructor(private fb: FormBuilder, private dashboardService: DashboardService) {}

  onSubmit(): void {
  }

  createAnuncio(): void {
    let data = this.anuncioForm.value;
    alert(this.anuncioForm.value.id);
    alert(this.anuncioForm.value.cliente);
    alert(this.anuncioForm.value.dataDeInicio);
    alert(this.anuncioForm.value.dataDeTermino);
    alert(this.anuncioForm.value.investimentoPorDia);
    this.dashboardService.create(data).subscribe(() => {
      alert('Anuncio criado com sucesso');
    })
  }
}
