package com.marti.appdetruco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class VistaGanador extends AppCompatActivity {

    private String unMensajeRecibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_ganador);

        Intent unIntent = getIntent();

        Bundle unBundle = unIntent.getExtras();

        unMensajeRecibido = unBundle.getString("winner");

        TextView unGanador = (TextView) findViewById(R.id.ganador);
        unGanador.setText(unMensajeRecibido);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent unIntent = getIntent();

        Bundle unBundle = unIntent.getExtras();

        unMensajeRecibido = unBundle.getString("winner");

        TextView unGanador = (TextView) findViewById(R.id.ganador);
        unGanador.setText(unMensajeRecibido);
    }

    public void reiniciarJuego(){

        Intent unIntent = new Intent(VistaGanador.this, MainActivity.class);
        Bundle unBundle = new Bundle();
        unIntent.putExtras(unBundle);

        startActivity(unIntent);
    }
}
