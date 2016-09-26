package com.marti.appdetruco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public String ganador;
    public Integer clickEnvido = 0;
    public Integer clickRealEnvido = 0;
    public Integer clickFaltaEnvido = 0;
    public Integer clickTruco = 0;
    public Integer clickRetruco = 0;
    public Integer clickValeCuatro = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent unIntent = getIntent();

        Bundle unBundle = unIntent.getExtras();

        TextView textView1 = (TextView) findViewById(R.id.puntosDisputados1);
        TextView textView2 = (TextView) findViewById(R.id.puntosTeam1);
        TextView textView3 = (TextView) findViewById(R.id.puntosTeam2);
        TextView textView4 = (TextView) findViewById(R.id.puntosDisputados2);

        textView1.setText("0");
        textView2.setText("0");
        textView3.setText("0");
        textView4.setText("0");
    }

    public void sumarEnvido(View view){
        TextView sumarEnvido = (TextView) findViewById(R.id.puntosDisputados1);
        String texto = sumarEnvido.getText().toString();
        TextView puntosTeam1 = (TextView) findViewById(R.id.puntosTeam1);
        String textoPuntosTeam = puntosTeam1.getText().toString();
        TextView nosotros = (TextView) findViewById(R.id.nosotros);
        String nosotrosString = nosotros.getText().toString();

        Integer numeroSumarEnvido = Integer.valueOf(String.valueOf(texto));
        Integer numeroPuntosTeam1 = Integer.valueOf(String.valueOf(textoPuntosTeam));

        Integer sumaFinal = numeroPuntosTeam1 + numeroSumarEnvido;
        String puntosTeamFinal = sumaFinal.toString();

        puntosTeam1.setText(puntosTeamFinal);

        sumarEnvido.setText("0");

        if(sumaFinal >= 30){
            ganador = nosotrosString;
            dispararGanador(ganador);
        }

    }

    public void sumarEnvido2(View view){
        TextView sumarEnvido = (TextView) findViewById(R.id.puntosDisputados1);
        String texto = sumarEnvido.getText().toString();
        TextView puntosTeam2 = (TextView) findViewById(R.id.puntosTeam2);
        String textoPuntosTeam = puntosTeam2.getText().toString();
        TextView ellos = (TextView) findViewById(R.id.ellos);
        String ellosString = ellos.getText().toString();

        Integer numeroSumarEnvido = Integer.valueOf(String.valueOf(texto));
        Integer numeroPuntosTeam2 = Integer.valueOf(String.valueOf(textoPuntosTeam));

        Integer sumaFinal = numeroPuntosTeam2 + numeroSumarEnvido;

        String puntosTeamFinal = sumaFinal.toString();

        puntosTeam2.setText(puntosTeamFinal);

        sumarEnvido.setText("0");

        if(sumaFinal >= 30){
            ganador = ellosString;
            dispararGanador(ganador);
        }

    }

    public void sumarTruco(View view){
        TextView sumarTruco = (TextView) findViewById(R.id.puntosDisputados2);
        String texto = sumarTruco.getText().toString();
        TextView puntosTeam1 = (TextView) findViewById(R.id.puntosTeam1);
        String textoPuntosTeam = puntosTeam1.getText().toString();
        TextView nosotros = (TextView) findViewById(R.id.nosotros);
        String nosotrosString = nosotros.getText().toString();

        Integer numeroSumarTruco = Integer.valueOf(String.valueOf(texto));
        Integer numeroPuntosTeam1 = Integer.valueOf(String.valueOf(textoPuntosTeam));

        Integer sumaFinal = numeroPuntosTeam1 + numeroSumarTruco;

        String puntosTeamFinal = sumaFinal.toString();

        puntosTeam1.setText(puntosTeamFinal);

        sumarTruco.setText("0");

        if (sumaFinal >= 30){
            ganador = nosotrosString;
            dispararGanador(ganador);
        }

    }

    public void sumarTruco2(View view){
        TextView sumarTruco = (TextView) findViewById(R.id.puntosDisputados2);
        String texto = sumarTruco.getText().toString();
        TextView puntosTeam1 = (TextView) findViewById(R.id.puntosTeam2);
        String textoPuntosTeam = puntosTeam1.getText().toString();
        TextView ellos = (TextView) findViewById(R.id.ellos);
        String ellosString = ellos.getText().toString();

        Integer numeroSumarTruco = Integer.valueOf(String.valueOf(texto));
        Integer numeroPuntosTeam1 = Integer.valueOf(String.valueOf(textoPuntosTeam));

        Integer sumaFinal = numeroPuntosTeam1 + numeroSumarTruco;

        String puntosTeamFinal = sumaFinal.toString();

        puntosTeam1.setText(puntosTeamFinal);

        sumarTruco.setText("0");

        if(sumaFinal >= 30){
            ganador = ellosString;
            dispararGanador(ganador);
        }

    }

    public void envidoAPuntosEnvido(View view){
        TextView puntosEnvido = (TextView) findViewById(R.id.puntosDisputados1);
        String texto = puntosEnvido.getText().toString();

        Integer sumarAEnvido = Integer.valueOf(String.valueOf(texto));
        Integer envido = 2;
        Integer sumaFinal = envido + sumarAEnvido;

        String puntosTeamFinal = sumaFinal.toString();

        puntosEnvido.setText(puntosTeamFinal);

        clickEnvido++;

    }

    public void realEnvidoPuntosEnvido(View view){
        TextView puntosRealEnvido = (TextView) findViewById(R.id.puntosDisputados1);
        String texto = puntosRealEnvido.getText().toString();

        Integer sumarAEnvido = Integer.valueOf(String.valueOf(texto));
        Integer sumaFinal = 3 + sumarAEnvido;

        String puntosTeamFinal = sumaFinal.toString();

        puntosRealEnvido.setText(puntosTeamFinal);

        clickRealEnvido++;

    }

//    public  void faltaEnvidoAPuntosEnvido(View view){
//        TextView puntosFaltaEnvido = (TextView) findViewById(R.id.puntosDisputados1);
//        String texto = puntosFaltaEnvido.getText().toString();
//
//        Integer sumarAEnvido = Integer.valueOf(String.valueOf(texto));
//        Hacer lo de el calculo del falta envido

//          clickFaltaEnvido++;
//    }

    public void trucoAPuntosTruco(View view){
        TextView puntosTruco = (TextView) findViewById(R.id.puntosDisputados2);
        String texto = puntosTruco.getText().toString();

        Integer sumarAEnvido = Integer.valueOf(String.valueOf(texto));
        Integer sumaFinal = 2 + sumarAEnvido;

        String puntosTeamFinal = sumaFinal.toString();

        puntosTruco.setText(puntosTeamFinal);

        clickTruco++;

    }

    public void reTrucoAPuntosTruco(View view){
        TextView puntosTruco = (TextView) findViewById(R.id.puntosDisputados2);
        String texto = puntosTruco.getText().toString();

        Integer sumarAEnvido = Integer.valueOf(String.valueOf(texto));
        Integer sumaFinal = 3 + sumarAEnvido;

        String puntosTeamFinal = sumaFinal.toString();

        puntosTruco.setText(puntosTeamFinal);

        clickRetruco++;
    }

    public void valeCuatroAPuntosTruco(View view){
        TextView puntosTruco = (TextView) findViewById(R.id.puntosDisputados2);
        String texto = puntosTruco.getText().toString();

        Integer sumarAEnvido = Integer.valueOf(String.valueOf(texto));
        Integer sumaFinal = 4 + sumarAEnvido;

        String puntosTeamFinal = sumaFinal.toString();

        puntosTruco.setText(puntosTeamFinal);

        clickValeCuatro++;

    }

    public boolean terminarPartida(Integer unPuntaje){
        TextView puntosTeam1 = (TextView) findViewById(R.id.puntosTeam1);
        String textoPuntosTeam = puntosTeam1.getText().toString();
        Integer numeroPuntosTeam1 = Integer.valueOf(String.valueOf(textoPuntosTeam));

        if (numeroPuntosTeam1 >= 30){
            return true;
        } else {
            return false;
        }
    }

    public void dispararGanador(String unGanador){

        Intent unIntent = new Intent(MainActivity.this, VistaGanador.class);
        Bundle unBundle = new Bundle();
        unBundle.putString("winner", ganador);
        unIntent.putExtras(unBundle);

        startActivity(unIntent);

    }



}
