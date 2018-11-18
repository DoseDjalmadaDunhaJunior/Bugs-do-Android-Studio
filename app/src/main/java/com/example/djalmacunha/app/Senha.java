package com.example.djalmacunha.app;

import java.io.Serializable;

// Classe que guarda informações da senha

public class Senha implements Serializable {
    int id;
    String senha;
    String login;
    String site;

    public Senha(String senha, String login, String site) {
        this(0, senha, login, site);
    }

    public Senha(int id, String senha, String login, String site) {
        this.id = id;
        this.senha = senha;
        this.login = login;
        this.site = site;
    }

    @Override
    public String toString() {
        return this.site;
    }
}
