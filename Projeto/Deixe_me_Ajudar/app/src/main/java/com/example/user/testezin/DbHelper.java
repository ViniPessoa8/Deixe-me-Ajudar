package com.example.user.testezin;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;

public class DbHelper extends SQLiteOpenHelper
{
    private static final String nome = "testeImagem.db";
    private static final int versao = 2;
    private final String CREATE_TABLE1 = "CREATE TABLE Usuario(id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, email TEXT NOT NULL, senha TEXT NOT NULL, admin boolean NOT NULL);";
    private final String tabelaConteudo = "CREATE TABLE Conteudo(id INTEGER PRIMARY KEY AUTOINCREMENT, anexo BLOB, titulo varchar (450) not null, conteudo longtext,tipo integer);";
    private final String tabelaInspiracao = "CREATE TABLE Inspiracao(id INTEGER PRIMARY KEY AUTOINCREMENT);";
    private final String tabelaExercicio = "CREATE TABLE Exercicios(id INTEGER PRIMARY KEY AUTOINCREMENT, tipo INTEGER NOT NULL, foreign key (id) references Conteudo(id));";
    private final String tabelaInformacao = "CREATE TABLE Informacao(id INTEGER PRIMARY KEY AUTOINCREMENT, foreign key (id) references Conteudo(id));";
    public DbHelper(Context context)
    {
        super(context,nome,null, versao);
    }

    @Override
    public void onCreate(SQLiteDatabase bd)
    {
        bd.execSQL(CREATE_TABLE1);
        bd.execSQL(tabelaConteudo);
        bd.execSQL(tabelaInspiracao);
        bd.execSQL(tabelaExercicio);
        bd.execSQL(tabelaInformacao);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int i, int i1)
    {
        bd.execSQL("DROP TABLE IF EXISTS Usuario");
        bd.execSQL("DROP TABLE IF EXISTS Conteudo");
        bd.execSQL("DROP TABLE IF EXISTS Inspiracao");
        bd.execSQL("DROP TABLE IF EXISTS Exercicios");
        bd.execSQL("DROP TABLE IF EXISTS Informacao");
        onCreate(bd);
    }

    public void query(String sql)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

    public void addConteudo(Conteudo conteudo)
    {
        SQLiteDatabase db = getWritableDatabase();
        String sql ="";
        if(conteudo.getAnexo() == null)
        {
            sql = "INSERT INTO Conteudo(titulo, conteudo,tipo) VALUES(?,?,"+ conteudo.getTipo() +");";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.clearBindings();
            statement.bindString(1,conteudo.getTitulo());
            statement.bindString(2,conteudo.getConteudo());
            statement.executeInsert();
        }else
        {
            sql = "INSERT INTO Conteudo(anexo, titulo, conteudo) VALUES(?,?,"+ conteudo.getTipo() +");";
            SQLiteStatement statement = db.compileStatement(sql);
            statement.clearBindings();
            statement.bindBlob(1, conteudo.getAnexo());
            statement.bindString(2,conteudo.getTitulo());
            statement.executeInsert();
        }
    }

    public int getIdConteudo(Conteudo conteudo)
    {
        SQLiteDatabase db = getWritableDatabase();
        int id = 0;
        Cursor cursor = db.rawQuery("SELECT * FROM Conteudo WHERE titulo='"+ conteudo.getTitulo() +"' AND conteudo='"+ conteudo.getConteudo() +"';",null);
        try
        {
            cursor.moveToFirst();
            id = cursor.getInt(cursor.getColumnIndex("id"));
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return id;
    }

    public int getIdConteudoTitulo(Conteudo conteudo)
    {
        SQLiteDatabase db = getWritableDatabase();
        int id = 0;
        Cursor cursor = db.rawQuery("SELECT * FROM Conteudo WHERE titulo='"+ conteudo.getTitulo() +"';",null);
        try
        {
            cursor.moveToFirst();
            id = cursor.getInt(cursor.getColumnIndex("id"));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return id;
    }

    public void addInspiracao(Inspiracao inspiracao)
    {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO Inspiracao(id) VALUES('"+ inspiracao.getId() +"');";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();
        statement.executeInsert();
    }

    public void addInformacao(Informacao informacao)
    {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO Informacao(id) VALUES('"+ informacao.getId() +"');";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();
        statement.executeInsert();
    }

    public void addExercicio(Exercicio exercicio)
    {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO Exercicios(id,tipo) VALUES('"+ exercicio.getId() +"','"+ exercicio.getTipo() +"');";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();
        statement.executeInsert();
    }

    public ArrayList<Conteudo> retornarTodos()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Conteudo> informacoes = new ArrayList<>();
        String sql = "SELECT * FROM Conteudo WHERE tipo = 1;";
        Cursor cursor = db.rawQuery(sql,null);

        while(cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String titulo = cursor.getString(cursor.getColumnIndex("titulo"));
            String conteudo = cursor.getString(cursor.getColumnIndex("conteudo"));
            informacoes.add(new Conteudo(null, titulo, conteudo, 1));
        }
        cursor.close();
        return informacoes;
    }

    public ArrayList<Conteudo> getConteudo(String conteudo)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<Conteudo> lista = new ArrayList<>();
        String sql = "SELECT * FROM Conteudo WHERE tipo =1 and titulo like '%"+ conteudo +"%' or conteudo like '%"+ conteudo +"%';";
        Cursor cursor = db.rawQuery(sql,null);

        while(cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String titulo = cursor.getString(cursor.getColumnIndex("titulo"));
            String texto = cursor.getString(cursor.getColumnIndex("conteudo"));
            lista.add(new Conteudo(null, titulo, texto,1));
        }
        cursor.close();
        return lista;
    }

    public List<Conteudo> getInformacao(String conteudo)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        List<Conteudo> lista = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM Conteudo WHERE titulo like '%"+ conteudo +"%' or conteudo like '%"+ conteudo +"%' and tipo=1;", null);
        while(cursor.moveToNext())
        {
            int id = cursor.getInt(cursor.getColumnIndex("id"));
            String titulo = cursor.getString(cursor.getColumnIndex("titulo"));
            String texto = cursor.getString(cursor.getColumnIndex("conteudo"));
            lista.add(new Conteudo(null, titulo, texto,1));
        }
        cursor.close();
        return lista;

    }


}
