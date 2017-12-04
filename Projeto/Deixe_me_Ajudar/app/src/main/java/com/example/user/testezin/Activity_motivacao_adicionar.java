package com.example.user.testezin;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Activity_motivacao_adicionar extends AppCompatActivity
{

    public static DbHelper sql;
    final int code = 999;
    ImageView imagem;
    Inspiracao inspiracao;
    Conteudo conteudo;
    private String emailUser;
    private boolean admin;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motivacao_adicionar);

        //Email passado como parâmetro da activity
        Intent intent = getIntent();
        emailUser = intent.getStringExtra("emailUser");
        admin = intent.getBooleanExtra("admin", false);

        sql = new DbHelper(this);

        Button btSelecionar = (Button)findViewById(R.id.btSelecionar);
        imagem = (ImageView)findViewById(R.id.imageView);
        ImageButton btVoltar = (ImageButton)findViewById(R.id.btVoltar);
        Button btAdicionar = (Button)findViewById(R.id.btAdicionar);



        conteudo = new Conteudo();
        inspiracao = new Inspiracao();


        btSelecionar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                ActivityCompat.requestPermissions(Activity_motivacao_adicionar.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, code);
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
                    conteudo.setTipo(3);
                    sql.addConteudo(conteudo);
                    //sql.addInspiracao(imageViewToByte(imagem));
                    Toast.makeText(getApplicationContext(),"Conteúdo adicionado com sucesso.",Toast.LENGTH_SHORT).show();
                    imagem.setImageResource(R.mipmap.ic_launcher);
                }catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Não foi possível adicionar o conteúdo.",Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Activity_motivacao_adicionar.this,Activity_motivacao.class);
                intent.putExtra("emailUser", emailUser);
                intent.putExtra("admin", admin);
                startActivity(intent);

                finish();
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
                //Toast.makeText(getApplicationContext(), "nunca nem vi", Toast.LENGTH_SHORT).show();
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


}
