package com.marti.appdetruco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public String ganador;
    private Integer clickEnvido = 0;
    private Integer clickRealEnvido = 0;
    private Integer clickFaltaEnvido = 0;
    private Integer clickTruco = 0;
    private Integer clickRetruco = 0;
    private Integer clickValeCuatro = 0;
    private Integer ganadorFaltaEnvido1;
    private Integer ganadorFaltaEnvido2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent unIntent = getIntent();

        Bundle unBundle = unIntent.getExtras();
    }

    @Override
    protected void onStart() {
        super.onStart();

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

    public void ganadorFaltaEnvido(){
        if (clickFaltaEnvido == 1){
            TextView puntosFaltaEnvido = (TextView) findViewById(R.id.puntosDisputados1);
            String textoPuntosTeam = puntosFaltaEnvido.getText().toString();

            Integer posicionGuionMedio = textoPuntosTeam.indexOf("-");
            String puntosTeam1 = textoPuntosTeam.substring(0, posicionGuionMedio - 1);
            String puntosTeam2 = textoPuntosTeam.substring(posicionGuionMedio + 2, textoPuntosTeam.length());

            Integer puntosFalta1 = Integer.valueOf(String.valueOf(puntosTeam1));
            Integer puntosFalta2 = Integer.valueOf(String.valueOf(puntosTeam2));

            ganadorFaltaEnvido1 = puntosFalta1;
            ganadorFaltaEnvido2 = puntosFalta2;

        }
    }

    public void sumarEnvido(View view){
        TextView puntosTeam1 = (TextView) findViewById(R.id.puntosTeam1);
        String textoPuntosTeam = puntosTeam1.getText().toString();

        TextView nosotros = (TextView) findViewById(R.id.nosotros);
        String nosotrosString = nosotros.getText().toString();

        TextView sumarEnvido = (TextView) findViewById(R.id.puntosDisputados1);
        String texto = sumarEnvido.getText().toString();

        Integer numeroSumarEnvido = Integer.valueOf(String.valueOf(texto));
        Integer numeroPuntosTeam1 = Integer.valueOf(String.valueOf(textoPuntosTeam));

        Integer gana;
        String ganaString;

        Integer sumaFinal;
        String puntosTeamFinal;

        if (clickFaltaEnvido == 1){
            ganadorFaltaEnvido();
            gana = ganadorFaltaEnvido1 + numeroPuntosTeam1;
            ganaString = gana.toString();
            puntosTeam1.setText(ganaString);

        } else {

            sumaFinal = numeroPuntosTeam1 + numeroSumarEnvido;
            puntosTeamFinal = sumaFinal.toString();
            puntosTeam1.setText(puntosTeamFinal);

        }

        TextView puntosTeam1Final = (TextView) findViewById(R.id.puntosTeam1);
        String textoPuntosTeamFinal = puntosTeam1Final.getText().toString();

        Integer numeroFinal = Integer.valueOf(String.valueOf(textoPuntosTeamFinal));


        sumarEnvido.setText("0");

        resetearContadorEnvido();

        if(numeroFinal >= 30){
            ganador = nosotrosString;
            dispararGanador(ganador);
        }
    }

    public void sumarEnvido2(View view){
        TextView puntosTeam2 = (TextView) findViewById(R.id.puntosTeam2);
        String textoPuntosTeam = puntosTeam2.getText().toString();

        TextView nosotros = (TextView) findViewById(R.id.ellos);
        String ellosString = nosotros.getText().toString();

        TextView sumarEnvido = (TextView) findViewById(R.id.puntosDisputados1);
        String texto = sumarEnvido.getText().toString();

        Integer numeroSumarEnvido = Integer.valueOf(String.valueOf(texto));
        Integer numeroPuntosTeam2 = Integer.valueOf(String.valueOf(textoPuntosTeam));

        Integer gana;
        String ganaString;

        Integer sumaFinal;
        String puntosTeamFinal;

        if (clickFaltaEnvido == 1){
            ganadorFaltaEnvido();
            gana = ganadorFaltaEnvido2 + numeroPuntosTeam2;
            ganaString = gana.toString();
            puntosTeam2.setText(ganaString);

        } else {

            sumaFinal = numeroPuntosTeam2 + numeroSumarEnvido;
            puntosTeamFinal = sumaFinal.toString();
            puntosTeam2.setText(puntosTeamFinal);

        }

        TextView puntosTeam1Final = (TextView) findViewById(R.id.puntosTeam2);
        String textoPuntosTeamFinal = puntosTeam1Final.getText().toString();

        Integer numeroFinal = Integer.valueOf(String.valueOf(textoPuntosTeamFinal));


        sumarEnvido.setText("0");

        resetearContadorEnvido();

        if(numeroFinal >= 30){
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

        resetearContadorTruco();

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

        resetearContadorTruco();

        if(sumaFinal >= 30){
            ganador = ellosString;
            dispararGanador(ganador);
        }
    }

    public void envidoAPuntosEnvido(View view){
        if (clickRealEnvido == 1 || clickFaltaEnvido == 1){

        } else if (clickEnvido == 0 || clickEnvido == 1){
            TextView puntosEnvido = (TextView) findViewById(R.id.puntosDisputados1);
            String texto = puntosEnvido.getText().toString();

            Integer sumarAEnvido = Integer.valueOf(String.valueOf(texto));
            Integer envido = 2;
            Integer sumaFinal = envido + sumarAEnvido;

            String puntosTeamFinal = sumaFinal.toString();

            puntosEnvido.setText(puntosTeamFinal);

            clickEnvido++;
        }
    }

    public void realEnvidoPuntosEnvido(View view){
        if (clickFaltaEnvido == 1){

        } else if (clickRealEnvido == 0 ){
            TextView puntosRealEnvido = (TextView) findViewById(R.id.puntosDisputados1);
            String texto = puntosRealEnvido.getText().toString();

            Integer sumarAEnvido = Integer.valueOf(String.valueOf(texto));
            Integer sumaFinal = 3 + sumarAEnvido;

            String puntosTeamFinal = sumaFinal.toString();

            puntosRealEnvido.setText(puntosTeamFinal);

            clickRealEnvido++;
        }
    }

    public  void faltaEnvidoAPuntosEnvido(View view){
        TextView puntosFaltaEnvido = (TextView) findViewById(R.id.puntosDisputados1);
        String texto = puntosFaltaEnvido.getText().toString();

        TextView puntosTeam1 = (TextView) findViewById(R.id.puntosTeam1);
        String puntosTeam1Texto = puntosTeam1.getText().toString();

        TextView puntosTeam2 = (TextView) findViewById(R.id.puntosTeam2);
        String puntosTeam2Texto = puntosTeam2.getText().toString();

        Integer sumarAEnvido = Integer.valueOf(String.valueOf(texto));
        Integer puntosTeam1Numero = Integer.valueOf(String.valueOf(puntosTeam1Texto));
        Integer puntosTeam2Numero = Integer.valueOf(String.valueOf(puntosTeam2Texto));

        Integer faltaEnvidoTeam1 = 0;
        Integer faltaEnvidoTeam2 = 0;

        if (clickFaltaEnvido == 0){
            if (puntosTeam1Numero >= 15 || puntosTeam2Numero >= 15){
                faltaEnvidoTeam1 = 30 - puntosTeam2Numero;
                faltaEnvidoTeam2 = 30 - puntosTeam1Numero;
            }

            if (puntosTeam1Numero < 15 && puntosTeam2Numero < 15){
                faltaEnvidoTeam1 = 30 - puntosTeam1Numero;
                faltaEnvidoTeam2 = 30 -puntosTeam2Numero;
            }

            String falta1Texto = faltaEnvidoTeam1.toString();
            String falta2Texto = faltaEnvidoTeam2.toString();

            puntosFaltaEnvido.setText(falta1Texto + " - " + falta2Texto);
        }


          clickFaltaEnvido++;
    }

    public void trucoAPuntosTruco(View view){
        if (clickRetruco == 1 || clickValeCuatro == 1){

        } else if(clickTruco == 0){
            TextView puntosTruco = (TextView) findViewById(R.id.puntosDisputados2);
            String texto = puntosTruco.getText().toString();

            Integer sumarAEnvido = Integer.valueOf(String.valueOf(texto));
            Integer sumaFinal = 2 + sumarAEnvido;

            String puntosTeamFinal = sumaFinal.toString();

            puntosTruco.setText(puntosTeamFinal);

            clickTruco++;
        }
    }

    public void reTrucoAPuntosTruco(View view){
        if (clickValeCuatro == 1){

        } else if (clickRetruco == 0 && clickTruco == 0){
            TextView puntosTruco = (TextView) findViewById(R.id.puntosDisputados2);
            String texto = puntosTruco.getText().toString();

            Integer sumarAEnvido = Integer.valueOf(String.valueOf(texto));
            Integer sumaFinal = 3 + sumarAEnvido;

            String puntosTeamFinal = sumaFinal.toString();

            puntosTruco.setText(puntosTeamFinal);

            clickRetruco++;
        } else if (clickTruco == 1 && clickRetruco == 0){
            TextView puntosTruco = (TextView) findViewById(R.id.puntosDisputados2);
            String texto = puntosTruco.getText().toString();

            Integer sumarAEnvido = Integer.valueOf(String.valueOf(texto));
            Integer sumaFinal = 1 + sumarAEnvido;

            String puntosTeamFinal = sumaFinal.toString();

            puntosTruco.setText(puntosTeamFinal);

            clickRetruco++;
        }
    }

    public void valeCuatroAPuntosTruco(View view){
        if (clickValeCuatro == 0 && clickRetruco == 0 && clickTruco == 0){
            TextView puntosTruco = (TextView) findViewById(R.id.puntosDisputados2);
            String texto = puntosTruco.getText().toString();

            Integer sumarAEnvido = Integer.valueOf(String.valueOf(texto));
            Integer sumaFinal = 4 + sumarAEnvido;

            String puntosTeamFinal = sumaFinal.toString();

            puntosTruco.setText(puntosTeamFinal);

            clickValeCuatro++;
        }
        if (clickValeCuatro == 0 && clickTruco == 1 && clickRetruco == 0){
            TextView puntosTruco = (TextView) findViewById(R.id.puntosDisputados2);
            String texto = puntosTruco.getText().toString();

            Integer sumarAEnvido = Integer.valueOf(String.valueOf(texto));
            Integer sumaFinal = 2 + sumarAEnvido;

            String puntosTeamFinal = sumaFinal.toString();

            puntosTruco.setText(puntosTeamFinal);

            clickValeCuatro++;
        }
        if (clickValeCuatro == 0 && clickTruco ==0 && clickRetruco == 1){
            TextView puntosTruco = (TextView) findViewById(R.id.puntosDisputados2);
            String texto = puntosTruco.getText().toString();

            Integer sumarAEnvido = Integer.valueOf(String.valueOf(texto));
            Integer sumaFinal = 1 + sumarAEnvido;

            String puntosTeamFinal = sumaFinal.toString();

            puntosTruco.setText(puntosTeamFinal);

            clickValeCuatro++;
        }
        if (clickValeCuatro == 0 && clickTruco == 1 && clickRetruco == 1){
            TextView puntosTruco = (TextView) findViewById(R.id.puntosDisputados2);
            String texto = puntosTruco.getText().toString();

            Integer sumarAEnvido = Integer.valueOf(String.valueOf(texto));
            Integer sumaFinal = 1 + sumarAEnvido;

            String puntosTeamFinal = sumaFinal.toString();

            puntosTruco.setText(puntosTeamFinal);

            clickValeCuatro++;
        }
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

    public void resetearContadorEnvido(){
        clickEnvido = 0;
        clickRealEnvido = 0;
        clickFaltaEnvido = 0;
    }

    public void resetearContadorTruco(){
        clickTruco = 0;
        clickRetruco = 0;
        clickValeCuatro = 0;
    }

}