package com.example.vinicius.login_cadastro_deixe_me_ajudar.activities;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.vinicius.login_cadastro_deixe_me_ajudar.R;
import com.example.vinicius.login_cadastro_deixe_me_ajudar.dao.DbHelper;
import com.example.vinicius.login_cadastro_deixe_me_ajudar.java.Conteudo;
import com.example.vinicius.login_cadastro_deixe_me_ajudar.java.Inspiracao;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Activity_admin_motivacao_adicionar extends AppCompatActivity
{
    public static DbHelper sql;
    final int code = 999;
    ImageView imagem;
    Inspiracao inspiracao;
    Conteudo conteudo;
    private String emailUser;
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        if(requestCode == code)
        {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, code);
            }else
            {
                Toast.makeText(getApplicationContext(), "nunca nem vi", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == code && resultCode == RESULT_OK && data != null)
        {
            Uri uri = data.getData();
            try
            {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imagem.setImageBitmap(bitmap);

            } catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        findViewById(R.id.includeadminmotivacaoadicionar).setVisibility(View.VISIBLE);
        sql = new DbHelper(this);

        //Email passado como parâmetro da activity
        Intent intent = getIntent();
        emailUser = intent.getStringExtra("emailUser");

        Button btSelecionar = findViewById(R.id.btnAdicionarImagem);
        imagem = findViewById(R.id.imageView);
        ImageButton btVoltar = findViewById(R.id.btVoltar);
        Button btAdicionar = findViewById(R.id.btAdicionar);

        conteudo = new Conteudo();
        inspiracao = new Inspiracao();


        btSelecionar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                ActivityCompat.requestPermissions(Activity_admin_motivacao_adicionar.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, code);
            }
        });

        btAdicionar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                try
                {
                    conteudo.setTitulo("");
                    conteudo.setTitulo("");
                    conteudo.setAnexo(imageViewToByte(imagem));
                    sql.addConteudo(conteudo);
                    //sql.addInspiracao(imageViewToByte(imagem));
                    Toast.makeText(getApplicationContext(),"funfou",Toast.LENGTH_SHORT).show();
                    imagem.setImageResource(R.mipmap.ic_launcher);
                }catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"deu treta ai",Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //setContentView(R.layout.activity_main);
                startActivity(new Intent(Activity_admin_motivacao_adicionar.this,Activity_admin_motivacao.class));

            }
        });

    }

    private byte[] imageViewToByte(ImageView img)
    {
        Bitmap bitmap = ((BitmapDrawable)img.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }


}
