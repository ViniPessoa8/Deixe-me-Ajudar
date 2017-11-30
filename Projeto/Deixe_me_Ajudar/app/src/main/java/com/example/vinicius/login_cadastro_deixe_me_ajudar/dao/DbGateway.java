package com.example.vinicius.login_cadastro_deixe_me_ajudar.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Vinicius on 27/11/2017.
 */

public class DbGateway {
    private static DbGateway gw;
    private SQLiteDatabase db;

    private DbGateway(Context ctx){
        DbHelper helper = new DbHelper(ctx);
        db = helper.getWritableDatabase();
    }

    public static DbGateway getInstance(Context ctx){
        if(gw == null)
            gw = new DbGateway(ctx);
        return gw;
    }

    public SQLiteDatabase getDatabase(){
        return this.db;
    }
}
