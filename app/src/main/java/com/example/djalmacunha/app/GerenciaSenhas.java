package com.example.djalmacunha.app;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class GerenciaSenhas {

    private Context ctx;

    public GerenciaSenhas(Context ctx) {
        this.ctx = ctx;
    }

    public List<Senha> retornarSenhas() {
        return retornarSenhas(null);
    }

    public List<Senha> retornarSenhas(String nomeB) {
        String sql = "SELECT id,senhaUser,loginUser,site FROM senhas";
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
            Senha senha = new Senha(id, senhaUser, login, site);
            senhas.add(senha);
        }
        dba.fecharConexao();

        return senhas;
    }

    public void salvarSenhas(Senha senha) {
        DBAdapter dba = new DBAdapter(ctx);
        String sql = senha.id == 0
                ? "INSERT INTO senhas(senhaUser,loginUser,site) VALUES ('%s','%s','%s')"
                : "UPDATE senhas SET senhaUser='%s',loginUser='%s',site='%s' WHERE id=" + senha.id;

        sql = String.format(sql, senha.senha, senha.login, senha.site);
        dba.executarComandoSQL(sql);
    }

    public void salvarUser(User user) {
        DBAdapter dba = new DBAdapter(ctx);
        String sql = user.id == 0
                ? "INSERT INTO user(login,senha) VALUES ('%s','%s')"
                : "UPDATE user SET login='%s',senha='%s' WHERE id=" + user.id;

        sql = String.format(sql, user.login, user.senha);


        dba.executarComandoSQL(sql);
    }

    /*
    public void excluirCliente(int id){
        DbAdapter dba = new DbAdapter(ctx);
        String sql = "DELETE FROM Clientes WHERE id=" + id;
        dba.executarComandoSQL(sql);
    }

    public static boolean validarCliente(Cliente c){
        if(c == null) return false;
        if(c.nome == null || c.nome.equals("")) return false;
        if(c.dataNascimento == null || c.dataNascimento.equals("")) return false;
        if(c.uf == null || c.uf.equals("")) return false;
        if(c.cidade == null || c.cidade.equals("")) return false;
        if(c.sexo == null || c.sexo.equals("")) return false;
        return true;
    }*/
}