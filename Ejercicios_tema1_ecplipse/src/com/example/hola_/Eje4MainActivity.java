package com.example.hola_;


import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class Eje4MainActivity extends Activity implements View.OnClickListener {
    private Button comenzar, menos ,mas;
    private TextView contadorCafes, contadorTiempo;
    private int cafes = 0, tiempo = 5;
    private MyCountDownTimer contadorDescendente;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eje4_main);

        menos = (Button) findViewById(R.id.buttonMenos);
        menos.setOnClickListener(this);
        mas = (Button) findViewById(R.id.buttonMas);
        mas.setOnClickListener(this);
        comenzar = (Button) findViewById(R.id.buttonComenzar);
        comenzar.setOnClickListener(this);
        contadorCafes = (TextView) findViewById(R.id.textViewContador);
        contadorTiempo = (TextView) findViewById(R.id.textViewTiempo);

        ponerContadorTiempo(5);
        ponerContadorCafes(0);
        
        i = this.getIntent();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v == menos) {
            ponerContadorTiempo((tiempo - 1)< 0 ? 0 : (tiempo - 1));
        }
        else if (v == mas) {
            ponerContadorTiempo(tiempo + 1);
        }
        else if (v == comenzar){
            contadorDescendente = new MyCountDownTimer(tiempo * 60 * 1000, 1000);
            contadorDescendente.start();
            menos.setEnabled(false);
            mas.setEnabled(false);
            comenzar.setEnabled(false); //CountDownTimer crea un hilo para su ejecución , 
            							//si presionamos n veces hacemos correr n hilos en paralelo.
            							//El boton comenzar estará desactivado al presionarlo.
        }
    }

    private void ponerContadorTiempo(int t) {
        if (t < 1) t=1;
        tiempo = t;
        contadorTiempo.setText(tiempo + ":00");
    }

    private void ponerContadorCafes(int c) {
        this.cafes = c;
        contadorCafes.setText(String.valueOf(cafes));
    }

    public class MyCountDownTimer extends
            CountDownTimer {
        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long minutos = (millisUntilFinished / 1000) / 60;
            long segundos = ((millisUntilFinished - 1000) / 1000)% 60;
            contadorTiempo.setText(minutos + ":" + (segundos<10? "0"+segundos : segundos));
        }

        @Override
        public void onFinish() {
            contadorCafes.setText("Pausa terminada!!");
            ponerContadorCafes(cafes + 1);
            comenzar.setEnabled(true);
        }
    }
}
