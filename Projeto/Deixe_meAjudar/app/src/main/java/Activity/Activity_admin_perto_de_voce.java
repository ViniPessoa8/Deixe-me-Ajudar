package Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.example.user.deixe_meajudar.R;

public class Activity_admin_perto_de_voce extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_perto_de_voce);

        Button btAdicionar = (Button)findViewById(R.id.btAdicionar);
        Button btBuscar = (Button)findViewById(R.id.btBuscar);
        Button btExcluir = (Button)findViewById(R.id.btExcluir);
        ImageButton btVoltar = (ImageButton)findViewById(R.id.btVoltar);

        btAdicionar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //setContentView(R.layout.admin_perto_de_voce_adicionar);
                //startActivity(new Intent(Activity_admin_perto_de_voce.this, Activity_admin_perto_de_voce_adicionar.class));
            }
        });

        btBuscar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //setContentView(R.layout.admin_perto_de_voce_buscar);
                //startActivity(new Intent(Activity_admin_perto_de_voce.this, Activity_admin_perto_de_voce_buscar.class));
            }
        });

        btExcluir.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //setContentView(R.layout.admin_perto_de_voce_excluir);
                //startActivity(new Intent(Activity_admin_perto_de_voce.this, Activity_admin_perto_de_voce_excluir.class));
            }
        });

        btVoltar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setContentView(R.layout.user_principal);
                startActivity(new Intent(Activity_admin_perto_de_voce.this, Activity_user_principal.class));
            }
        });
    }
}
