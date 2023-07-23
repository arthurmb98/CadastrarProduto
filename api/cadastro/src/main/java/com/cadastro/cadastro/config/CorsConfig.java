package com.cadastro.cadastro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Date;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    public static class UsuarioLogado{
        private static long id;
        private static String nome;
        private static boolean logado;
        private static Date data;

        public static boolean isLogado() throws Exception {
            if(!logado){
                throw new Exception("Usuário não logado!");
            }
            return logado;
        }

        public static long getId() {
            return id;
        }

        public static void setId(long id) {
            UsuarioLogado.id = id;
        }

        public static String getNome() {
            return nome;
        }

        public static void setNome(String nome) {
            UsuarioLogado.nome = nome;
        }

        public static void setLogado(boolean logado) {
            UsuarioLogado.logado = logado;
        }

        public static Date getData() {
            return data;
        }

        public static void setData(Date data) {
            UsuarioLogado.data = data;
        }
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}