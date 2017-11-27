package DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Fernanda Serra on 20/11/2017.
 */

public class BancoOpenHelper extends SQLiteOpenHelper{

    public BancoOpenHelper(Context context)
    {
        super(context, "deixeMeAjudar.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String comando = "\n" +
                "create table usuario\n" +
                "(\n" +
                "\temail varchar(150) not null,\n" +
                "    senha varchar (50) not null,\n" +
                "    id int auto_increment not null,\n" +
                "    primary key (id)\n" +
                ");\n" +
                "\n" +
                "create table relatorio\n" +
                "(\n" +
                "\tconteudo longtext not null,\n" +
                "    intensidade int(10) not null,\n" +
                "    idUser int not null,\n" +
                "    foreign key (idUser) references usuario(id),\n" +
                "    id int auto_increment not null,\n" +
                "    primary key (id)\n" +
                ");\n" +
                "\n" +
                "create table conteudo\n" +
                "(\n" +
                "\tid int auto_increment not null,\n" +
                "    primary key (id),\n" +
                "    anexo longblob,\n" +
                "    titulo varchar (450) not null,\n" +
                "    conteudo longtext,\n" +
                "    tipo int not null,\n" +
                "    endereco longtext not null\n" +
                ");";
        db.execSQL(comando);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {

    }
}
