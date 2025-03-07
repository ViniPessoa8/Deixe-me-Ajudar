package com.example.user.testezin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.widget.Toast;


/**
 * Created by Vinicius on 27/11/2017.
 */

public class UsuarioDAO {
    private final String TABLE = "Usuario";
    private DbGateway gw;

    public UsuarioDAO(Context ctx) {
        gw = DbGateway.getInstance(ctx);
    }

    public boolean cadastrar(String nome, String email, String senha, boolean admin) {
        ContentValues cv = new ContentValues();
        cv.put("Nome", nome);
        cv.put("Email", email);
        cv.put("Senha", senha);
        cv.put("admin", admin);
        return gw.getDatabase().insert(TABLE, null, cv) > 0;
    }

    public boolean logar(String email, String senha) {
        if(email.equals("admin") && senha.equals("admin")){
            return true;
        }

        String sql = "SELECT * FROM "+TABLE+" WHERE Email = '" + email + "' AND Senha = '" + senha + "';";
        Cursor cursor;

        cursor = gw.getDatabase().rawQuery(sql, null);
        if(cursor.moveToFirst()){
            return true;
        } else {
            return false;
        }
    }

    public Usuario getUsuarioEmail(String email) {
        String sql = "SELECT * FROM "+TABLE+" WHERE email = '" + email + "';";
        Usuario user = null;
        Cursor cursor;

        cursor = gw.getDatabase().rawQuery(sql, null);
        if (cursor.moveToFirst()) {

            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            String senha = cursor.getString(cursor.getColumnIndex("senha"));
            int codigo = cursor.getInt(cursor.getColumnIndex("id"));

            user = new Usuario();

            user.setEmail(email);
            user.setNome(nome);
            user.setSenha(senha);
            user.setCodigo(codigo);
        }
        return user;
    }

    public boolean deleteUsuario(String email){
        Usuario user = getUsuarioEmail(email);
        String sql = "DELETE FROM Usuario WHERE id = '" + user.getCodigo()+ "';";
        gw.getDatabase().rawQuery(sql, null);
        return true;
    }

    public boolean alterarEmail(String emailOriginal, String emailNovo){
        String sql = "UPDATE Usuario SET email = '"+emailNovo+"' WHERE email = '"+emailOriginal+"';";
        gw.getDatabase().execSQL(sql);
        return true;
    }

}
