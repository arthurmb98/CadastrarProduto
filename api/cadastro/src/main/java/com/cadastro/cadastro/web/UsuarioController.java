package com.cadastro.cadastro.web;

import com.cadastro.cadastro.domain.Usuario;
import com.cadastro.cadastro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController  {
    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody Usuario usuario){
        usuario = this.repository.findByNomeAndSenha(usuario.getNome(), usuario.getSenha());
        if(usuario != null){
            return new ResponseEntity<>(true, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(false, HttpStatus.FORBIDDEN);
        }
    }
    @PostMapping("/add")
    public ResponseEntity<Usuario> add(@RequestBody Usuario usuario) {
        Usuario usr;
        try{
            usr = repository.save(usuario);
            return new ResponseEntity<>(usr, HttpStatus.CREATED);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public List<Usuario> getAll() throws Exception {
        return repository.findAll();
    }

}
