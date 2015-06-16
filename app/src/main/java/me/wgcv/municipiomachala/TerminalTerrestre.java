package me.wgcv.municipiomachala;

import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;


public class TerminalTerrestre extends ActionBarActivity {
    MenuLateral menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terminal_terrestre);
        menu = new MenuLateral(this);
        Button boton = (Button) findViewById(R.id.Consultar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TableLayout tablelayout = (TableLayout) findViewById(R.id.tabla);

                tablelayout.setVisibility(View.VISIBLE);

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
