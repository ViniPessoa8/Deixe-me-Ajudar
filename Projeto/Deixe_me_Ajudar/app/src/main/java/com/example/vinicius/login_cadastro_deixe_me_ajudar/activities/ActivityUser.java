package com.example.vinicius.login_cadastro_deixe_me_ajudar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.vinicius.login_cadastro_deixe_me_ajudar.R;
import com.example.vinicius.login_cadastro_deixe_me_ajudar.dao.UsuarioDAO;


public class ActivityUser extends AppCompatActivity {

    private String emailUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);

        //Email passado como parâmetro da activity
        Intent intent = getIntent();
        emailUser = intent.getStringExtra("emailUser");

        //Geral
        ImageButton btnVoltarInicio = findViewById(R.id.btnVoltarInicioUser);
        ImageButton btnVoltarMenuPrincipal = findViewById(R.id.btnVoltarMenuPrincipal);

        btnVoltarInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            resetTelas();
            startActivity(new Intent(ActivityUser.this, ActivityInicio.class));
            }
        });

        btnVoltarMenuPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTelas();
                findViewById(R.id.includeuserprincipal).setVisibility(View.VISIBLE);
            }
        });

        //Página Inicial

        ImageView btnMotivacao = findViewById(R.id.btnMotivacao);
        ImageView btnRelatorio = findViewById(R.id.btnRelatorio);
        ImageView btnPertoDeVoce = findViewById(R.id.btnPertoDeVoce);
        ImageView btnConfig = findViewById(R.id.btnConfig);
        ImageView btnExercicios = findViewById(R.id.btnExercicios);
        ImageView btnInformacoes = findViewById(R.id.btnInformacoes);

        btnMotivacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTelas();
                findViewById(R.id.includeusermotivacao).setVisibility(View.VISIBLE);
            }
        });
        btnRelatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTelas();
                findViewById(R.id.includeuserrelatorio).setVisibility(View.VISIBLE);
            }
        });
        btnPertoDeVoce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTelas();
                findViewById(R.id.includeuserpertodevoce).setVisibility(View.VISIBLE);
            }
        });
        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTelas();
                findViewById(R.id.includeuserconfig).setVisibility(View.VISIBLE);
            }
        });
        btnExercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTelas();
                findViewById(R.id.includeuserexercicios).setVisibility(View.VISIBLE);
            }
        });
        btnInformacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTelas();
                findViewById(R.id.includeuserinformacoes).setVisibility(View.VISIBLE);
            }
        });

        //Motivação
        Button btnFavoritos = findViewById(R.id.btnFavoritos);

        btnFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //Relatório
        Button btnConsultar = findViewById(R.id.btnUserConsultar);
        Button btnGerar = findViewById(R.id.btnUserGerar);

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnGerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //Perto de Você
        //Configurações
        Button btAlterarEmail = findViewById(R.id.btAlterar);
        Button btAlterarSenha = findViewById(R.id.btAlterarSenha);
        Button btExcluirConta = findViewById(R.id.btExcluirConta);
        ImageButton btVoltar = findViewById(R.id.btVoltar);


        btAlterarEmail.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //setContentView(R.layout.configuracoes_alterar_email);
                //startActivity(new Intent(Activity_configuracoes.this,Activity_configuracoes_alterarEmail.class));
                findViewById(R.id.includeuserconfig).setVisibility(View.INVISIBLE);
                findViewById(R.id.includeuseralteraremail).setVisibility(View.VISIBLE);

            }
        });

        btAlterarSenha.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //setContentView(R.layout.configuracoes_alterar_senha);
                //startActivity(new Intent(Activity_configuracoes.this, Activity_configuracoes_alterarSenha.class));
                findViewById(R.id.includeuserconfig).setVisibility(View.INVISIBLE);
                findViewById(R.id.includeuseralterarsenha).setVisibility(View.VISIBLE);
            }
        });

        btExcluirConta.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //setContentView(R.layout.configuracoes_desativar_conta);
                //startActivity(new Intent(Activity_configuracoes.this, Activity_configuracoes_excluirConta.class));
                findViewById(R.id.includeuserconfig).setVisibility(View.INVISIBLE);
                findViewById(R.id.includeuserexcluirconta).setVisibility(View.VISIBLE);
            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                findViewById(R.id.includeuserconfig).setVisibility(View.INVISIBLE);
                findViewById(R.id.includeadminprincipal).setVisibility(View.VISIBLE);
            }
        });
            //ExcluirConta
            ImageButton btnVoltar = findViewById(R.id.btnVoltarMenuPrincipalUser);
            Button btnExcluir = findViewById(R.id.btnUserExcluirConta);

            btnExcluir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditText etSenha = findViewById(R.id.etSenhaExcluirConta);
                    String senha = etSenha.getText().toString();
                    UsuarioDAO userDao = new UsuarioDAO(getApplicationContext());
                    if(userDao.logar(emailUser, senha)){
                        userDao.deleteUsuario(emailUser);
                        Toast.makeText(ActivityUser.this, "Conta excluida.", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ActivityUser.this, ActivityInicio.class));
                    } else {
                        Toast.makeText(ActivityUser.this, "Senha incorreta!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            btnVoltar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetTelas();
                    findViewById(R.id.includeuserprincipal).setVisibility(View.VISIBLE);
                }
            });

            //Alterar Email
            Button btAlterar = findViewById(R.id.btAlterar);
            ImageButton btnVoltarAlterarEmail = findViewById(R.id.btVoltarAlterarEmail);

            btAlterar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    UsuarioDAO userDao = new UsuarioDAO(getApplicationContext());
                    EditText etEmailNovo = findViewById(R.id.txtNewEmail);
                    EditText etEmailConfirma = findViewById(R.id.txtConfirmacao);
                    EditText etSenha = findViewById(R.id.txtSenhaAlterarEmail);

                    String email = etEmailNovo.getText().toString();
                    String confirmaEmail = etEmailConfirma.getText().toString();
                    String senha = etSenha.getText().toString();

                    if(email.equals(confirmaEmail)){
                        if(userDao.logar(emailUser, senha)){
                            if(userDao.alterarEmail(emailUser, email)){
                                Toast.makeText(ActivityUser.this, "O E-mail foi alterado com sucesso.", Toast.LENGTH_SHORT).show();
                                resetTelas();
                                findViewById(R.id.includeuserprincipal).setVisibility(View.VISIBLE);
                            }
                        } else {
                            Toast.makeText(ActivityUser.this, "Senha incorreta!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(ActivityUser.this, "Os E-mails não são iguais!", Toast.LENGTH_SHORT).show();
                    }

                }
            });
            btnVoltarAlterarEmail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetTelas();
                    findViewById(R.id.includeuserprincipal).setVisibility(View.VISIBLE);
                }
            });

        //Exercícios
        Button btnMeditacoes = findViewById(R.id.btnUserMeditacoes);
        Button btnVideos = findViewById(R.id.btnUserVideos);
        Button btnOutros = findViewById(R.id.btnUserOutros);

        btnMeditacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnVideos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnOutros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //Informações
        Button btnInformacoesFavoritos = findViewById(R.id.btnUserInformacoesFavoritos);

        btnInformacoesFavoritos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void resetTelas(){
        findViewById(R.id.includeuserconfig).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeuserexercicios).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeuserinformacoes).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeusermotivacao).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeuserpertodevoce).setVisibility(View.INVISIBLE);
        findViewById(R.id.includeuserrelatorio).setVisibility(View.INVISIBLE);
    }

}
