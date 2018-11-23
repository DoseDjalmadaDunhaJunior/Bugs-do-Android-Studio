package com.example.djalmacunha.app;

import java.io.Serializable;

// Classe que guarda informações da senha

public class Senha implements Serializable {
    int id;
    String senha;
    String login;
    String site;
    String usuario;

    public Senha(String senha, String login, String site, String usuario) {
        this(0, senha, login, site, usuario);
    }

    public Senha(int id, String senha, String login, String site, String usuario) {
        this.id = id;
        this.senha = senha;
        this.login = login;
        this.site = site;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return this.site;
    }
}
