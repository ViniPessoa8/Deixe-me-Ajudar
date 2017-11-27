package Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.deixe_meajudar.R;

public class Activity_configuracoes extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.configuracoes);

        Button btAlterarEmail = (Button)findViewById(R.id.btAlterarEmail);
        Button btAlterarSenha = (Button)findViewById(R.id.btAlterarSenha);
        Button btDesativarConta = (Button)findViewById(R.id.btDesativarConta);

        btAlterarEmail.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setContentView(R.layout.configuracoes_alterar_email);
                //startActivity(new Intent(Activity_configuracoes.this, Activity_alterar_email.class));
            }
        });


        btAlterarSenha.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setContentView(R.layout.configuracoes_alterar_senha);
               // startActivity(new Intent(Activity_configuracoes.this, Activity_alterar_senha.class));
            }
        });


        btDesativarConta.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setContentView(R.layout.configuracoes_desativar_conta);
                //startActivity(new Intent(Activity_configuracoes.this, Activity_desativar_conta.class));
            }
        });
    }
}
