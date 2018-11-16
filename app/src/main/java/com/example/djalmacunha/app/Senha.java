package com.example.djalmacunha.app;

import java.io.Serializable;

public class Senha implements Serializable {
    int id;
    String senha;
    String login;
    String site;

    //Método construtor
    public Senha(String senha, String login, String site) {
        this(0, senha, login, site);
    }

    //Método construtor
    public Senha(int id, String senha, String login, String site) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.site = site;
    }

    //O método toString é uma representação em texto do seu objeto que retorna o nome da classe mais uma representação
    // hexadecimal do código hash do seu objeto
    @Override
    public String toString() {
        return this.login;
    }
}
