package com.cadastro.cadastro.repository;

import com.cadastro.cadastro.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    ArrayList<Produto> findAll();
    Produto findById(long id);
    Produto save(Produto produto);
    void deleteById(long id);
}
