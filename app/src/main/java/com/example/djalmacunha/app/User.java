package com.example.djalmacunha.app;

import java.io.Serializable;

public class User implements Serializable {
    int id;
    String login;
    String senha;

    //Método construtor
    public User(String login, String senha, String site) {
        this(0, login, senha);
    }

    //Método construtor
    public User(int id, String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
    }

    //O método toString é uma representação em texto do seu objeto que retorna o nome da classe mais uma representação
    // hexadecimal do código hash do seu objeto
    @Override
    public String toString() {
        return this.login;
    }
}

