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

public class Activity_logar extends AppCompatActivity {

    UsuarioDAO usuarioDAO = new UsuarioDAO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logar);
        Button btLogar = (Button) findViewById(R.id.btLogar);
        ImageButton btVoltar = (ImageButton) findViewById(R.id.btVoltar);

        btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtEmail = (EditText) findViewById(R.id.txtEmail);
                EditText txtSenha = (EditText) findViewById(R.id.txtSenha);

                if (txtEmail.getText().toString().equals("") || txtSenha.getText().toString().equals("")) {
                    Toast.makeText(Activity_logar.this, "Um campo importante está vazio.", Toast.LENGTH_SHORT).show();
                } else {
                    Usuario usuario = new Usuario();
                    usuario.setEmail(txtEmail.getText().toString());
                    usuario.setSenha(txtSenha.getText().toString());

                    usuarioDAO.abrir();
                    if (usuarioDAO.logar(usuario)) {
                        setContentView(R.layout.user_principal);
                        Intent intent = new Intent(Activity_logar.this, Activity_user_principal.class);
                        intent.putExtra("emailUsuario", usuario.getEmail());
                        startActivity(intent);
                    } else {
                        Toast.makeText(Activity_logar.this, "Não foi possível executar login.", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_inicio);
                startActivity(new Intent(Activity_logar.this, inicio.class));
            }
        });
    }
}
