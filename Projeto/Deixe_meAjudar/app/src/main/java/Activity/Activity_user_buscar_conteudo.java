package Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.user.deixe_meajudar.R;

public class Activity_user_buscar_conteudo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_buscar_conteudo);
        ImageView btnBuscar = findViewById(R.id.btnBuscar);
        ImageView btnVoltar = findViewById(R.id.btnVoltar);
        final EditText etConteudoNome = findViewById(R.id.etConteudoNome);

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String conteudoNome = etConteudoNome.getText().toString();
                buscar(conteudoNome);
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltar();
            }
        });
    }

    private void buscar (String conteudoNome){

    }

    private void voltar (){
        setContentView(R.layout.user_principal);
    }
}
