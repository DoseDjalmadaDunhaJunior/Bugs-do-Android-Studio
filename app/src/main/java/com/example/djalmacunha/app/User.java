package com.example.djalmacunha.app;

import java.io.Serializable;

// Classe que armazena informações do usuário

public class User implements Serializable {
    int id;
    String login;
    String senha;

    public User(String login, String senha, String site) {
        this(0, login, senha);
    }

    public User(int id, String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return this.login;
    }
}

