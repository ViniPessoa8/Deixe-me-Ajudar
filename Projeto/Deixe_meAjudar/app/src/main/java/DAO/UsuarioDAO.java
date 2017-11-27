package DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.user.deixe_meajudar.Usuario;

public class UsuarioDAO
{
    private SQLiteDatabase bd;
    private SQLiteOpenHelper openHelper;

    public UsuarioDAO(Context context)
    {
        openHelper = new BancoOpenHelper(context);
    }

    public void abrir()
    {
        bd = openHelper.getWritableDatabase();
    }

    public void cadastrar(Usuario user)
    {
        try
        {
            ContentValues valores = new ContentValues();
            valores.put("nome", user.getNome());
            valores.put("senha", user.getSenha());
            valores.put("email", user.getEmail());
            bd.insert("usuario", null, valores);
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public boolean verificarEmail(Usuario user)
    {
        boolean resultado = false;
        Cursor cursor = bd.rawQuery("select * from usuario where email='"+ user.getEmail() + "';", null);

        if(cursor.moveToFirst())
        {
            resultado = true;
        }

        return resultado;
    }

    public boolean logar(Usuario user)
    {
        boolean resultado = false;
        if(verificarEmail(user))
        {
           Cursor cursor = bd.rawQuery("select senha from usuario where email='"+ user.getEmail() + "';", null);
           cursor.moveToFirst();
           String senha = cursor.getString(cursor.getColumnIndex("senha"));
           cursor.close();
           if(user.getSenha().equals(senha))
           {
               resultado = true;
           }
        }
        return resultado;
    }


}
