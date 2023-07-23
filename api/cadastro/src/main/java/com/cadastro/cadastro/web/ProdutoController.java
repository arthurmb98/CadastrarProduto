package com.cadastro.cadastro.web;

import com.cadastro.cadastro.domain.Produto;
import com.cadastro.cadastro.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;


    @PostMapping("/add")
    public ResponseEntity<Produto> add(@RequestBody Produto produto) throws Exception {
        Produto p;
        try{
            p = repository.save(produto);
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) throws Exception {
        repository.deleteById(id);
    }

    @PutMapping("update")
    public Produto atualizar(@RequestBody Produto produto) throws Exception {
        return repository.save(produto);
    }
    @GetMapping("/all")
    public List<Produto> getAll() throws Exception {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Produto getById(@PathVariable("id") long id) throws Exception {
        return repository.findById(id);
    }
}
