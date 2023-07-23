import { Component, OnInit } from '@angular/core';
import { ProdutoService } from 'src/app/shared/service/produto.service';

@Component({
  selector: 'app-produtos-list',
  templateUrl: './produtos-list.component.html',
  styleUrls: ['./produtos-list.component.css']
})
export class ProdutosListComponent implements OnInit {

  produtos: any;

  constructor(private service: ProdutoService) {
  }

  ngOnInit(): void {
    this.pesquisar();

  }

  pesquisar() {
    this.service.getProdutos().subscribe((response: any) => {
      this.produtos = response;
    });

  }
}