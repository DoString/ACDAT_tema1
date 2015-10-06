package com.example.hola_;

import java.text.NumberFormat;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class Eje1MainActivity extends Activity implements OnClickListener {

	private Button calcular;
	private Button salir;
	private EditText dolares;
	private EditText euros;
	private EditText factor;
	private RadioGroup gr;
	private double cambio;
	private Intent i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.eje1_activity_main);

		calcular = (Button) findViewById(R.id.button6);
		calcular.setOnClickListener(this);
		salir = (Button)findViewById(R.id.button7);
		salir.setOnClickListener(this);
		gr = (RadioGroup) findViewById(R.id.radioGroup1);
		dolares = (EditText) findViewById(R.id.editText2);
		euros = (EditText) findViewById(R.id.editText1);
		factor = (EditText) findViewById(R.id.editText3);
		
		i = this.getIntent();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.eje1_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		if (v == calcular)
			this.Calcular(this.gr);
		else if (v == salir) 
			this.finish();		
	}

	
	public void Calcular(RadioGroup gr) {
		// Comprobamos si el campo cambio está vacio
		if (this.factor.getText().toString().isEmpty())			
			return;
		
		// Si no está vacío parseamos su valor si se puede, sino salimos
		try {
			this.cambio = Double.parseDouble(this.factor.getText().toString());
		
		} catch (Exception e) {
			return;
		}
		// Comprobamos si el valor es 0
		if (this.cambio == 0) return;
		
		// Si Dolares a Euro esta activado:
		if (gr.getCheckedRadioButtonId() == R.id.radio0) {
			if (this.dolares.getText().toString().isEmpty()) return;
			
			this.euros.setText(String.format("%.2f",
							(Double.parseDouble(this.dolares.getText().toString()) / this.cambio)));
			return;
		}
		// Sino es Euros a Dolares
		if (this.euros.getText().toString().isEmpty()) return;
		this.dolares.setText(String.format("%.2f",
						(Double.parseDouble(this.euros.getText().toString()) * this.cambio)));
	}

}
