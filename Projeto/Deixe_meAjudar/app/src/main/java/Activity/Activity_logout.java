package Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.deixe_meajudar.R;

public class Activity_logout extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logout);

        Button btMenuPrincipal = (Button)findViewById(R.id.btTelaPrincipal);

        btMenuPrincipal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                setContentView(R.layout.logout);
                startActivity(new Intent(Activity_logout.this, inicio.class));
            }
        });
    }
}
