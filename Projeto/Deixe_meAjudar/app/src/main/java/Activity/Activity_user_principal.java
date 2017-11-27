package Activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.user.deixe_meajudar.R;
import com.example.user.deixe_meajudar.Usuario;

public class Activity_user_principal extends AppCompatActivity {

    Usuario usuario = new Usuario();

    protected void onCreate(Bundle savedInstanceState, Usuario usuario) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_principal);
        this.usuario = usuario;

        ImageView btnRelatorio = findViewById(R.id.btnRelatorio);
        ImageView btnMotivacao = findViewById(R.id.btnMotivacao);
        ImageView btnPertoDeVoce = findViewById(R.id.btnPertoDeVoce);
        ImageView btnConfig = findViewById(R.id.btnConfig);
        ImageView btnExercicios = findViewById(R.id.btnExercicios);
        ImageView btnInformacoes = findViewById(R.id.btnInformacoes);
        ImageView btnVoltar = findViewById(R.id.btnVoltar);

        btnRelatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.user_relatorio);
            }
        });

        btnMotivacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.user_motivacao);
            }
        });

        btnPertoDeVoce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //setContentView(R.layout.user_pertodevoce);
            }
        });

        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //setContentView(R.layout.user_config);
            }
        });

        btnExercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.user_exercicios);
            }
        });

        btnInformacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.user_informacoes);
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltar();
            }
        });
    }

    private void voltar() {
        new AlertDialog.Builder(this)
                .setTitle("Deletando curso")
                .setMessage("Tem certeza que deseja deletar esse curso?")
                .setPositiveButton("sim",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                setContentView(R.layout.activity_inicio);
                            }
                        })
                .setNegativeButton("não", null)
                .show();
    }

}

