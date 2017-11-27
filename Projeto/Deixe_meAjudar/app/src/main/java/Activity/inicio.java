package Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.deixe_meajudar.R;

public class inicio extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        Button btCadastrar = (Button)findViewById(R.id.btCadastrar);
        Button btLogar = (Button)findViewById(R.id.btLogar);

        btCadastrar.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                setContentView(R.layout.cadastrar);
                startActivity(new Intent(inicio.this, Activity_cadastrar.class));
            }

        });

        btLogar.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                setContentView(R.layout.logar);
                startActivity(new Intent(inicio.this, Activity_logar.class));
            }

        });

    }
}
