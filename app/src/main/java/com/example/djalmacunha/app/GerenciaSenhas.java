package com.example.djalmacunha.app;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

// Classe com todas as funções de gerencia do banco

public class GerenciaSenhas {

    private Context ctx;

    public GerenciaSenhas(Context ctx) {
        this.ctx = ctx;
    }

    public List<Senha> retornarSenhas(String user) {
        return retornarSenhas(null, user);
    }

    public List<Senha> retornarSenhas(String nomeB, String user) {
        String sql = "SELECT id,senhaUser,loginUser,site, usuario FROM senhas WHERE usuario='" + user +"'";
        if (nomeB != null && !nomeB.equals(""))
            sql += " WHERE senhaUser LIKE %";

        List<Senha> senhas = new ArrayList<>();
        DBAdapter dba = new DBAdapter(ctx);
        Cursor cursor = dba.executarConsultaSQL(sql);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String senhaUser = cursor.getString(1);
            String login = cursor.getString(2);
            String site = cursor.getString(3);
            String usuario = cursor.getString(4);
            Senha senha = new Senha(id, senhaUser, login, site, usuario);
            senhas.add(senha);
        }
        dba.fecharConexao();

        return senhas;
    }

    public List<User> retornarUser(String usuario) {
        return retornarUser(null,usuario);
    }

    public List<User> retornarUser(String nomeB,String usuario) {
        String sql = "SELECT id,login,senha FROM user WHERE login='"+usuario + "'";
        if (nomeB != null && !nomeB.equals(""))
            sql += " WHERE login LIKE %";

        List<User> users = new ArrayList<>();
        DBAdapter dba = new DBAdapter(ctx);
        Cursor cursor = dba.executarConsultaSQL(sql);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String login = cursor.getString(1);
            String senha = cursor.getString(2);
            User user = new User(id,login,senha);
            users.add(user);
        }
        dba.fecharConexao();


        return users;
    }

    public void salvarSenhas(Senha senha) {
        DBAdapter dba = new DBAdapter(ctx);
        String sql = senha.id == 0
                ? "INSERT INTO senhas(senhaUser,loginUser,site,usuario) VALUES ('%s','%s','%s','%s')"
                : "UPDATE senhas SET senhaUser='%s',loginUser='%s',site='%s',usuario='%s' WHERE id=" + senha.id;

        sql = String.format(sql, senha.senha, senha.login, senha.site, senha.usuario);
        dba.executarComandoSQL(sql);
    }

    public void salvarUser(User user) {

        DBAdapter dba = new DBAdapter(ctx);
        String sql = user.id == 0 ? "INSERT INTO user(login,senha)" +
                " VALUES ('%s','%s')" : "UPDATE user SET login='%s',senha='%s'" +
                " WHERE id=" + user.id;

        sql = String.format(sql, user.login, user.senha);
        dba.executarComandoSQL(sql);

        /*
        DBAdapter dba = new DBAdapter(ctx);
        String sql = user.id == 0
                ? "INSERT INTO user(login,senha) VALUES ('%s','%s')"
                : "UPDATE user SET login='%s',senha='%s' WHERE id=" + user.id;

        sql = String.format(sql, user.login, user.senha);


        dba.executarComandoSQL(sql);*/
    }

    public void excluirSenha(int id){
        DBAdapter dba = new DBAdapter(ctx);
        String sql = "DELETE FROM senhas WHERE id=" + id;
        dba.executarComandoSQL(sql);
    }

    public void exluirUser(int id){
        DBAdapter dba = new DBAdapter(ctx);
        String sql = "DELETE FROM user WHERE id=" + id;
        dba.executarComandoSQL(sql);
    }
}