package com.example.vinicius.login_cadastro_deixe_me_ajudar.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.example.vinicius.login_cadastro_deixe_me_ajudar.java.Conteudo;
import com.example.vinicius.login_cadastro_deixe_me_ajudar.java.Exercicio;
import com.example.vinicius.login_cadastro_deixe_me_ajudar.java.Informacao;
import com.example.vinicius.login_cadastro_deixe_me_ajudar.java.Inspiracao;

/**
 * Created by Vinicius on 27/11/2017.
 */

public class DbHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "DeixeMeAjudar.db";
    private static final int DATABASE_VERSION = 3;
    private final String CREATE_TABLE1 = "CREATE TABLE Usuario(id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, email TEXT NOT NULL, senha TEXT NOT NULL, admin boolean NOT NULL);";
    private final String CREATE_TABLE2 = "CREATE TABLE Relatorio(id INTEGER PRIMARY KEY AUTOINCREMENT, conteudo TEXT not null, intensidade int(10) not null, idUser INTEGER not null, FOREIGN KEY (idUser) REFERENCES Usuario(id));";
    private final String CREATE_TABLE3 = "CREATE TABLE Conteudo(id INTEGER PRIMARY KEY AUTOINCREMENT, anexo BLOB, titulo varchar (450) not null, Conteudo longtext, tipo integer not null, idAdmin INTEGER NOT NULL, FOREIGN KEY(idAdmin) REFERENCES Usuario(id));";
    private final String CREATE_TABLE4 = "CREATE TABLE Inspiracao(id INTEGER PRIMARY KEY AUTOINCREMENT, foreign key (id) references Conteudo(id));";
    private final String CREATE_TABLE5 = "CREATE TABLE Informacao(id INTEGER PRIMARY KEY AUTOINCREMENT, foreign key (id) references Conteudo(id));";
    private final String CREATE_TABLE6 = "CREATE TABLE Exercicios(id INTEGER PRIMARY KEY AUTOINCREMENT, tipo INTEGER NOT NULL, foreign key (id) references Conteudo(id));";
    private final String CREATE_TABLE7 = "CREATE TABLE PertoDeVoce(id INTEGER PRIMARY KEY AUTOINCREMENT,  endereco TEXT NOT NULL, foreign key (id) references Conteudo(id));";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(CREATE_TABLE1);
        bd.execSQL(CREATE_TABLE2);
        bd.execSQL(CREATE_TABLE3);
        bd.execSQL(CREATE_TABLE4);
        bd.execSQL(CREATE_TABLE5);
        bd.execSQL(CREATE_TABLE6);
        bd.execSQL(CREATE_TABLE7);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Usuario");
        db.execSQL("DROP TABLE IF EXISTS Relatorio");
        db.execSQL("DROP TABLE IF EXISTS Conteudo");
        db.execSQL("DROP TABLE IF EXISTS Inspiracao");
        db.execSQL("DROP TABLE IF EXISTS Informacao");
        db.execSQL("DROP TABLE IF EXISTS Exercicios");
        db.execSQL("DROP TABLE IF EXISTS PertoDeVoce");
        onCreate(db);
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
        String sql = "INSERT INTO Inspiracao(id,anexo) VALUES('"+ inspiracao.getId() +"',?);";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.clearBindings();
        statement.bindBlob(1, inspiracao.getFoto());
        statement.executeInsert();
    }

    public void addExercicio(Exercicio exercicio)
    {
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO Exercicio(id,tipo) VALUES('"+ exercicio.getId() +"','"+ exercicio.getTipo() +"');";
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


    public Cursor getData(String sql)
    {
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery(sql, null);
    }

    public Cursor getListaInformacao()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM Conteudo WHERE tipo = 1;";
        Cursor cursor = db.rawQuery(sql,null);
        return cursor;
    }

    public Cursor getConteudo(String conteudo)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM Conteudo WHERE titulo like '%"+ conteudo +"%' or conteudo like '%"+ conteudo +"%';";
        Cursor cursor = db.rawQuery(sql,null);
        return cursor;
    }
}
