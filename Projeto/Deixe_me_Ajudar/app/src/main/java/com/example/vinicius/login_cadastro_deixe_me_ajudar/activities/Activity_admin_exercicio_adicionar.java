package com.example.vinicius.login_cadastro_deixe_me_ajudar.activities;

import android.Manifest;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.vinicius.login_cadastro_deixe_me_ajudar.R;
import com.example.vinicius.login_cadastro_deixe_me_ajudar.dao.DbHelper;
import com.example.vinicius.login_cadastro_deixe_me_ajudar.java.Conteudo;
import com.example.vinicius.login_cadastro_deixe_me_ajudar.java.Exercicio;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Activity_admin_exercicio_adicionar extends AppCompatActivity
{
    ImageView imagem;
    public static DbHelper sql;
    private int tipoExercicio = 0;
    final int code = 999;
    Conteudo conteudo;
    Exercicio exercicio;
    EditText txtConteudo;
    private String emailUser;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        findViewById(R.id.includeadminexercicios).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeadminexercicioadicionar).setVisibility(View.VISIBLE);

        //Email passado como parâmetro da activity
        Intent intent = getIntent();
        emailUser = intent.getStringExtra("emailUser");

        Button btSelecionarAnexo = findViewById(R.id.btAdicionarAnexo);
        Button btAdicionar = findViewById(R.id.btAdicionarExercicio);
        ImageButton btVoltar = findViewById(R.id.btVoltar);
        imagem = findViewById(R.id.imageView);

        final Spinner spinner = (Spinner)findViewById(R.id.tipoExercicio);
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.spinner_exercicios, android.R.layout.simple_dropdown_item_1line);
        adaptador.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adaptador);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adaptador, View view, int i, long l)
            {
                if(adaptador.getSelectedItem().toString().equals("Meditações"))
                {
                    tipoExercicio = 1;
                }else if (adaptador.getSelectedItem().toString().equals("Vídeos"))
                {
                    tipoExercicio = 2;
                }else if(adaptador.getSelectedItem().toString().equals("Imagens"))
                {
                    tipoExercicio = 3;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });


        btSelecionarAnexo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                ActivityCompat.requestPermissions(Activity_admin_exercicio_adicionar.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, code);
            }
        });

        btAdicionar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                try
                {
                    EditText txtTitulo = (EditText)findViewById(R.id.txtTitulo);
                    txtConteudo = (EditText)findViewById(R.id.txtConteudo);
                    String titulo = txtTitulo.getText().toString();
                    String texto = txtConteudo.getText().toString();

                    conteudo = new Conteudo();
                    conteudo.setTitulo(titulo);
                    conteudo.setTipo(2);
                    conteudo.setConteudo(texto);

                    if(spinner.getSelectedItem().toString().equals("Imagens"))
                    {
                        conteudo.setAnexo(imageViewToByte(imagem));

                    }else
                    {
                        conteudo.setAnexo(null);
                    }

                    sql = new DbHelper(getApplicationContext());
                    sql.addConteudo(conteudo);

                    exercicio = new Exercicio();
                    exercicio.setTipoExercicio(tipoExercicio);
                    exercicio.setId(sql.getIdConteudoTitulo(conteudo));
                    sql.addExercicio(exercicio);

                    Toast.makeText(getApplicationContext(),"Exercício adicionado com sucesso.",Toast.LENGTH_SHORT).show();
                    txtTitulo.setText("");
                    spinner.setSelection(0);
                    txtConteudo.setText("");
                    imagem.setImageResource(R.mipmap.ic_launcher);
                    imagem.setImageResource(R.drawable.ic_launcher_foreground);
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Activity_admin_exercicio_adicionar.this, Activity_admin_exercicio.class);
                intent.putExtra("emailUser", emailUser);
                startActivity(intent);
            }
        });
    }

    private byte[] imageViewToByte(ImageView img)
    {
        byte [] byteArray = {0};
        try
        {
            Bitmap bitmap = ((BitmapDrawable)img.getDrawable()).getBitmap();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
            byteArray = stream.toByteArray();
        }catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"Esse tipo de exercício necessita de uma imagem.",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

        return byteArray;
    }

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
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
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
