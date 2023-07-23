package com.cadastro.cadastro.web;

import com.cadastro.cadastro.config.CorsConfig;
import com.cadastro.cadastro.domain.Usuario;
import com.cadastro.cadastro.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController  {
    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario){
        usuario = this.repository.findByNomeAndSenha(usuario.getNome(), usuario.getSenha());
        if(usuario != null){
            CorsConfig.UsuarioLogado.setId(usuario.getId());
            CorsConfig.UsuarioLogado.setNome(usuario.getNome());
            CorsConfig.UsuarioLogado.setLogado(true);
            CorsConfig.UsuarioLogado.setData(new Date());

            return new ResponseEntity<>("Usuario logado.", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Usuario ou senha incorretos.", HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<String> logout() throws Exception {
        CorsConfig.UsuarioLogado.setLogado(!CorsConfig.UsuarioLogado.isLogado());
        CorsConfig.UsuarioLogado.setId(-1);
        CorsConfig.UsuarioLogado.setNome(null);
        CorsConfig.UsuarioLogado.setData(null);
        return new ResponseEntity<>("Usuario deslogado.", HttpStatus.OK);
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
        CorsConfig.UsuarioLogado.isLogado();
        return repository.findAll();
    }

}
