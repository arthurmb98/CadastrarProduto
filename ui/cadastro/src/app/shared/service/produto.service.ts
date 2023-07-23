import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {
  readonly url = "http://localhost:8081";

  constructor(private http: HttpClient) { }

  getProdutos(): Observable<any[]> {
    return this.http.get<any>(this.url + '/produto/all');
  }

  addProduto(val: any) {
    return this.http.post(this.url + '/produto/add', val);
  }

  updateProduto(val: any) {
    return this.http.put(this.url + '/produto/update', val);
  }

  deleteProduto(val: any) {
    return this.http.delete(this.url + '/produto/' + val);
  }


}
