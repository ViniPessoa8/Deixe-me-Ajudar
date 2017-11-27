package Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.user.deixe_meajudar.R;
import com.example.user.deixe_meajudar.Usuario;

import DAO.UsuarioDAO;

public class Activity_cadastrar extends AppCompatActivity
{
    UsuarioDAO usuarioDAO;
    EditText txtEmail;
    EditText txtSenha;
    EditText txtConfirmacaoSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        setContentView(R.layout.cadastrar);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        Button btCadastrar = (Button)findViewById(R.id.btCadastrar);
        ImageButton btVoltar = (ImageButton)findViewById(R.id.btVoltar);
        usuarioDAO = new UsuarioDAO(this);

        btCadastrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                txtEmail = (EditText)findViewById(R.id.txtEmail);
                txtSenha = (EditText)findViewById(R.id.txtSenha);
                txtConfirmacaoSenha = (EditText)findViewById(R.id.txtConfirmacao);
                if(txtEmail.getText().toString().equals("") ||  txtSenha.getText().toString().equals("") ||  txtConfirmacaoSenha.getText().toString().equals(""))
                {
                    Toast.makeText(Activity_cadastrar.this,"Um campo importante está vazio.", Toast.LENGTH_SHORT).show();
                }else
                {
                    if(txtSenha.getText().toString().equals(txtConfirmacaoSenha.getText().toString()))
                    {
                        Usuario usuario = new Usuario();
                        usuario.setEmail(txtEmail.getText().toString());
                        usuario.setSenha(txtSenha.getText().toString());

                        usuarioDAO.abrir();
                        if(usuarioDAO.verificarEmail(usuario))
                        {
                            usuarioDAO.cadastrar(usuario);
                            Toast.makeText(Activity_cadastrar.this, "Cadastro Realizado.", Toast.LENGTH_SHORT).show();
                            setContentView(R.layout.logar);
                            startActivity(new Intent(Activity_cadastrar.this, Activity_logar.class));
                        }else
                        {
                            Toast.makeText(Activity_cadastrar.this, "Você já está cadastrado no sistema.", Toast.LENGTH_SHORT).show();
                        }

                    }else
                    {
                        Toast.makeText(Activity_cadastrar.this,"As senhas digitadas não são compatíveis.",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setContentView(R.layout.activity_inicio);
                startActivity(new Intent(Activity_cadastrar.this,inicio.class));
            }
        });
    }
}
