package Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.user.deixe_meajudar.R;
public class Activity_admin_exercicios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_exercicios);

        Button btAdicionar = (Button)findViewById(R.id.btAdicionar);
        Button btBuscar = (Button)findViewById(R.id.btBuscar);
        Button btExcluir = (Button)findViewById(R.id.btExcluir);
        ImageButton btVoltar = (ImageButton)findViewById(R.id.btVoltar);

        btAdicionar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //setContentView(R.layout.admin_exercicios_adicionar);
                //startActivity(new Intent(Activity_admin_exercicios.this, Activity_admin_exercicios_adicionar.class));
            }
        });

        btBuscar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //setContentView(R.layout.admin_exercicios_buscar);
                //startActivity(new Intent(Activity_admin_exercicios.this, Activity_admin_exercicios_buscar.class));
            }
        });

        btExcluir.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //setContentView(R.layout.admin_exercicios_excluir);
                //startActivity(new Intent(Activity_admin_exercicios.this, Activity_admin_exercicios_excluir.class));
            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setContentView(R.layout.user_principal);
                startActivity(new Intent(Activity_admin_exercicios.this, Activity_user_principal.class));
            }
        });
    }
}
