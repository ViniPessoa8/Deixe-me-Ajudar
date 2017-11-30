package com.example.vinicius.login_cadastro_deixe_me_ajudar.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vinicius on 27/11/2017.
 */

public class DbHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "DeixeMeAjudar.db";
    private static final int DATABASE_VERSION = 2;
    private final String CREATE_TABLE1 = "CREATE TABLE Usuario(id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, email TEXT NOT NULL, senha TEXT NOT NULL, admin boolean NOT NULL);";
    private final String CREATE_TABLE2 = "CREATE TABLE Relatorio(id INTEGER PRIMARY KEY AUTOINCREMENT, conteudo TEXT not null, intensidade int(10) not null, idUser INTEGER not null, FOREIGN KEY (idUser) REFERENCES Usuario(id));";
    private final String CREATE_TABLE3 = "CREATE TABLE Conteudo(id INTEGER PRIMARY KEY AUTOINCREMENT, anexo BLOB, titulo varchar (450) not null, Conteudo longtext, tipo int not null, idAdmin INTEGER NOT NULL, FOREIGN KEY(idAdmin) REFERENCES Usuario(id));";
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
        onCreate(db);
    }
}
