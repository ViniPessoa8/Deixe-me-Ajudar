package Activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.ImageView;

import com.example.user.deixe_meajudar.R;

public class Activity_admin_principal extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_principal);

        ImageView btnMotivacaoAdmin = findViewById(R.id.btnMotivacaoAdmin);
        ImageView btnConfigAdmin = findViewById(R.id.btnConfigAdmin);
        ImageView btnExerciciosAdmin = findViewById(R.id.btnExerciciosAdmin);
        ImageView btnPertoDeVoceAdmin = findViewById(R.id.btnPertoDeVoceAdmin);
        ImageView btnInformacoesAdmin = findViewById(R.id.btnInformacoesAdmin);
        ImageView btnVoltarAdminPrincipal = findViewById(R.id.btnVoltar);

        btnMotivacaoAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.admin_motivacao);
            }
        });

        btnConfigAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //setContentView(R.layout.admin_c);
            }
        });

        btnExerciciosAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.admin_exercicios);
            }
        });

        btnPertoDeVoceAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.admin_perto_de_voce);
            }
        });

        btnInformacoesAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.admin_informacoes);
            }
        });

        btnVoltarAdminPrincipal.setOnClickListener(new View.OnClickListener() {
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
