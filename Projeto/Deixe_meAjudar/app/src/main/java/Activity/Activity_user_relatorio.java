package Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.deixe_meajudar.R;

public class Activity_user_relatorio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_relatorio);

        Button btConsultar = (Button)findViewById(R.id.btConsultar);
        Button btGerar = (Button)findViewById(R.id.btGerar);

        btConsultar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setContentView(R.layout.user_relatorio_consulta);
               //startActivity(new Intent(Activity_user_relatorio.this, Activity_user_relatorio_consultar.class));
            }
        });

        btGerar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //setContentView(R.layout.user_relatorio);
            }
        });
    }
}
