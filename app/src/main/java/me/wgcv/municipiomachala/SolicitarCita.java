package me.wgcv.municipiomachala;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class SolicitarCita extends ActionBarActivity {
    MenuLateral menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitar_cita);
        menu = new MenuLateral(this);
        Button boton = (Button) findViewById(R.id.button);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.especialidades, R.layout.spinner_item);
        Spinner spinner = (Spinner) findViewById(R.id.spinner2);

        spinner.setAdapter(adapter);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SolicitarCita.this, Principal.class);
                SolicitarCita.this.startActivity(intent);
                Toast.makeText(getApplicationContext(), "Su solicitud de cita fue agregada", Toast.LENGTH_LONG).show();

            }
        });

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        menu.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        menu.onConfigurationChanged(newConfig);
    }
}
