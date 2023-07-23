package com.cadastro.cadastro.repository;

import com.cadastro.cadastro.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario,Long> {
    ArrayList<Usuario> findAll();
    Usuario findById(long id);

    @Query("select usr from Usuario usr " +
            " where usr.nome = :nome " +
            " and usr.senha = :senha")
    Usuario findByNomeAndSenha(@Param("nome")String nome,
                               @Param("senha") String senha);
    Usuario save(Usuario usuario);
    void deleteById(long id);
}
